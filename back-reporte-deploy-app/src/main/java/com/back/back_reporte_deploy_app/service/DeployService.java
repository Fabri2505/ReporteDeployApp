package com.back.back_reporte_deploy_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.dto.CambioCreateDTO;
import com.back.back_reporte_deploy_app.dto.CambioResponseDTO;
import com.back.back_reporte_deploy_app.dto.ComponenteDeployCreateDTO;
import com.back.back_reporte_deploy_app.dto.ComponenteDeployResponseDTO;
import com.back.back_reporte_deploy_app.dto.DeployCreateDTO;
import com.back.back_reporte_deploy_app.dto.DeployResponseDTO;
import com.back.back_reporte_deploy_app.dto.IncidenteCreateDTO;
import com.back.back_reporte_deploy_app.dto.IncidenteResponseDTO;
import com.back.back_reporte_deploy_app.dto.NewFuncionalidadCreateDTO;
import com.back.back_reporte_deploy_app.dto.NewFuncionalidadResponseDTO;
import com.back.back_reporte_deploy_app.dto.ResponsablesDeployDTO;
import com.back.back_reporte_deploy_app.dto.ValidacionDeployResponseDTO;
import com.back.back_reporte_deploy_app.entity.Deploy;
import com.back.back_reporte_deploy_app.entity.DetDeploy;
import com.back.back_reporte_deploy_app.entity.DetDeployId;
import com.back.back_reporte_deploy_app.entity.DetRespDeploy;
import com.back.back_reporte_deploy_app.entity.DetRespDeployId;
import com.back.back_reporte_deploy_app.entity.Feature;
import com.back.back_reporte_deploy_app.entity.PasoDeploy;
import com.back.back_reporte_deploy_app.entity.PlanRollback;
import com.back.back_reporte_deploy_app.entity.Proyecto;
import com.back.back_reporte_deploy_app.entity.Responsable;
import com.back.back_reporte_deploy_app.entity.Validacion;
import com.back.back_reporte_deploy_app.exceptions.BadRequestException;
import com.back.back_reporte_deploy_app.exceptions.ResourceNotFoundException;
import com.back.back_reporte_deploy_app.repository.DeployRepository;
import com.back.back_reporte_deploy_app.repository.DetDeployRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class DeployService {
    private final DeployRepository deployRepository;
    private final ProyectoService proyectoService;
    private final ResponsableService responsableService;
    private final ProcesoDeployService procesoDeployService;
    private final PlanRollBackService planRollBackService;
    private final DetDeployRepository detDeployRepository;
    private final TipoDeployService tipoDeployService;
    private final ValidacionService validacionService;
    private final CambioService cambioService;
    private final NewFuncionalidadService newFuncionalidadService;
    private final ComponenteDeployService componenteDeployService;
    private final IncidenteService incidenteService;


    public DeployResponseDTO registerDeploy(DeployCreateDTO deployCreateDTO) {

        Proyecto proyecto= proyectoService.getProyectoById(deployCreateDTO.getIdProyecto());
        Deploy newDeploy = this.buildDeploy(deployCreateDTO, proyecto);
        List<Responsable> responsables = responsableService.getResponsablesByIds(deployCreateDTO.getIdResponsables());
        // Lógica para registrar el despliegue
        newDeploy = deployRepository.save(newDeploy);
        
        List<DetRespDeploy> detRespDeploys = new ArrayList<>();
        for (Responsable responsable : responsables) {    

            DetRespDeployId id = DetRespDeployId.builder()
                .responsable(responsable.getId())
                .deploy(newDeploy.getId())
                .build();

            detRespDeploys.add(DetRespDeploy.builder()
                .id(id)
                .deploy(newDeploy)
                .responsable(responsable)
                .build());
        }

        responsableService.saveAllDetRespDeploys(detRespDeploys);

        newDeploy.setDetRespDeploys(detRespDeploys);
        if (deployCreateDTO.getFeature() != null) {
            
            List<DetDeploy> detDeploys = new ArrayList<>();
            List<PasoDeploy> pasosDeploy = procesoDeployService.getPasosDeploysForIdProceDeploy(deployCreateDTO.getIdProcesoDespliegue());
            for (PasoDeploy pasoDeploy : pasosDeploy) {

                DetDeployId id = DetDeployId.builder()
                    .pasoDeploy(pasoDeploy.getId())
                    .feature(newDeploy.getId())
                    .build();

                detDeploys.add(DetDeploy.builder()
                    .id(id)
                    .feature((Feature)newDeploy)
                    .pasoDeploy(pasoDeploy)
                    .build()
                );
            }

            detDeployRepository.saveAll(detDeploys);
            ((Feature)newDeploy).setDetDeploys(detDeploys);
            
        }

        List<Validacion> valids = validacionService.getValidacionForTipoDeploy(newDeploy.getTipo().getId());

        validacionService.insertDetalleValidacion(newDeploy, valids);
        
        return DeployResponseDTO.builder()
                .version(newDeploy.getVersion())
                .id(newDeploy.getId())
                .fechaRegistro(newDeploy.getFecha().atTime(newDeploy.getHoraIni()))
                .tipoDeploy(newDeploy.getTipo().getNom())
                .responsables(responsables.stream().map(responsable -> 
                    ResponsablesDeployDTO.builder()
                        .id(responsable.getId())
                        .nombre(responsable.getNom()+" "+responsable.getApe())
                        .cargo(responsable.getCargo())
                        .build()
                ).toList())
                .build();
    }

    private Feature getFeatureFromId(Long idDeploy){
        Deploy deploy = this.getDeployForId(idDeploy);
        if (deploy == null) {
            throw new ResourceNotFoundException("Deploy no encontrado con ID: " + idDeploy);
        }
        if (deploy instanceof Feature == false) {
            throw new BadRequestException("El Deploy con ID: " + idDeploy + " no es de tipo Feature");
        }

        return (Feature) deploy;
    }

    private Deploy buildDeploy(DeployCreateDTO deployCreateDTO, Proyecto proyecto){

        Deploy.DeployBuilder<?,?> deployBuilder;

        if (deployCreateDTO.getFeature() != null){
            PlanRollback planRoll = planRollBackService.getPlanRollbackById(deployCreateDTO.getIdRollback());
            deployBuilder = Feature.builder()
                .downTime(deployCreateDTO.getFeature().getDownTime())
                .nivelRiesgo(deployCreateDTO.getFeature().getNivelRiesgo())
                .planRollback(planRoll);
        } else {
            deployBuilder = Deploy.builder();
        }

        return deployBuilder.version(deployCreateDTO.getVersion())
            .fecha(deployCreateDTO.getFechaDeploy().toLocalDate())
            .horaIni(deployCreateDTO.getFechaDeploy().toLocalTime())
            .sprint(deployCreateDTO.getSprint())
            .tipo(tipoDeployService.getTipoDeployForId(deployCreateDTO.getIdTipoDeploy()))
            .proyecto(proyecto)
            .build();
    }

    public Deploy getDeployForId(Long idDeploy){
        return deployRepository.findById(idDeploy)
            .orElseThrow(() -> new ResourceNotFoundException("TipoDeploy no encontrado"));
    }

    public List<ValidacionDeployResponseDTO> getValidaciones(Long idDeploy){

        this.getDeployForId(idDeploy);

        return validacionService.getDetValidacionForDeploy(idDeploy)
            .stream().map(detValid -> ValidacionDeployResponseDTO
                .builder()
                .id(detValid.getId())
                .hecho(detValid.getHecho())
                .comentario(detValid.getComentario())
                .nomValidacion(detValid.getValidacion().getNom())
                .build()).toList();
    }

    public List<CambioResponseDTO> asignarCambios(Long idDeploy, List<CambioCreateDTO> cambios) {

        var feature = this.getFeatureFromId(idDeploy);

        return cambioService.crearCambios(cambios, feature);
    }

    public List<NewFuncionalidadResponseDTO> asignarFuncionalidades(Long idDeploy, List<NewFuncionalidadCreateDTO> funcionalidades) {
        
        var feature = this.getFeatureFromId(idDeploy);
        return newFuncionalidadService.crearFuncionalidades(funcionalidades, feature);
    }

    public List<ComponenteDeployResponseDTO> asignarComponentes(Long idDeploy, List<ComponenteDeployCreateDTO> componentes) {
        
        var feature = this.getFeatureFromId(idDeploy);
        return componenteDeployService.crearComponentes(componentes, feature);
    }

    public List<IncidenteResponseDTO> asignarIncidentes(Long idDeploy, List<IncidenteCreateDTO> incidentes) {
        
        var feature = this.getFeatureFromId(idDeploy);
        return incidenteService.crearIncidentes(incidentes, feature);
    }

}
