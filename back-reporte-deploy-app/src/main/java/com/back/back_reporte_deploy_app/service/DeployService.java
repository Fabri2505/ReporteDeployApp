package com.back.back_reporte_deploy_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.dto.DeployCreateDTO;
import com.back.back_reporte_deploy_app.dto.DeployResponseDTO;
import com.back.back_reporte_deploy_app.dto.ResponsablesDeployDTO;
import com.back.back_reporte_deploy_app.entity.Deploy;
import com.back.back_reporte_deploy_app.entity.DetDeploy;
import com.back.back_reporte_deploy_app.entity.DetRespDeploy;
import com.back.back_reporte_deploy_app.entity.Feature;
import com.back.back_reporte_deploy_app.entity.PasoDeploy;
import com.back.back_reporte_deploy_app.entity.PlanRollback;
import com.back.back_reporte_deploy_app.entity.Proyecto;
import com.back.back_reporte_deploy_app.entity.Responsable;
import com.back.back_reporte_deploy_app.repository.DeployRepository;
import com.back.back_reporte_deploy_app.repository.DetDeployRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeployService {
    private final DeployRepository deployRepository;
    private final ProyectoService proyectoService;
    private final ResponsableService responsableService;
    private final ProcesoDeployService procesoDeployService;
    private final PlanRollBackService planRollBackService;
    private final DetDeployRepository detDeployRepository;
    private final TipoDeployService tipoDeployService;

    public DeployResponseDTO registerDeploy(DeployCreateDTO deployCreateDTO) {

        Proyecto proyecto= proyectoService.getProyectoById(deployCreateDTO.getIdProyecto());
        Deploy newDeploy = this.buildDeploy(deployCreateDTO, proyecto);
        List<Responsable> responsables = responsableService.getResponsablesByIds(deployCreateDTO.getIdResponsables());
        // Lógica para registrar el despliegue
        newDeploy = deployRepository.save(newDeploy);
        
        List<DetRespDeploy> detRespDeploys = new ArrayList<>();
        for (Responsable responsable : responsables) {    
            detRespDeploys.add(DetRespDeploy.builder()
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
                detDeploys.add(DetDeploy.builder()
                    .feature((Feature)newDeploy)
                    .pasoDeploy(pasoDeploy)
                    .build()
                );
            }

            detDeployRepository.saveAll(detDeploys);
            ((Feature)newDeploy).setDetDeploys(detDeploys);
            
        }
        
        return DeployResponseDTO.builder()
                .version(newDeploy.getVersion())
                .id(newDeploy.getId())
                .fechaRegistro(newDeploy.getFecha().atTime(newDeploy.getHoraIni()))
                .tipoDeploy(newDeploy.getTipo())
                .responsables(responsables.stream().map(responsable -> 
                    ResponsablesDeployDTO.builder()
                        .id(responsable.getId())
                        .nombre(responsable.getNom()+" "+responsable.getApe())
                        .cargo(responsable.getCargo())
                        .build()
                ).toList())
                .build();
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
}
