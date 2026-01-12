package com.back.back_reporte_deploy_app.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.dto.DeployResponseDTO;
import com.back.back_reporte_deploy_app.dto.ProyectoCreateDTO;
import com.back.back_reporte_deploy_app.dto.ProyectoResponseDTO;
import com.back.back_reporte_deploy_app.dto.ResponsablesDeployDTO;
import com.back.back_reporte_deploy_app.entity.Deploy;
import com.back.back_reporte_deploy_app.entity.DetRespDeploy;
import com.back.back_reporte_deploy_app.entity.Proyecto;
import com.back.back_reporte_deploy_app.exceptions.ResourceNotFoundException;
import com.back.back_reporte_deploy_app.repository.ProyectoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProyectoService {
    private final ProyectoRepository proyectoRepository;

    public List<ProyectoResponseDTO> getProyectos() {

        List<Proyecto> proyectos = proyectoRepository.findAll();
        List<Deploy> deploys;
        List<DetRespDeploy> responsables;

        List<ProyectoResponseDTO> proyectoResponses = new ArrayList<>();

        for (Proyecto proyecto : proyectos) {

            var proyectoDTO = ProyectoResponseDTO.builder()
                .id(proyecto.getId())
                .nombre(proyecto.getNombre())
                .deploys(new ArrayList<DeployResponseDTO>()).build();

            deploys = proyecto.getDeploys();
            if (!deploys.isEmpty() || deploys != null){
                for (Deploy deploy : deploys) {
                    responsables = deploy.getDetRespDeploys();
                    List<ResponsablesDeployDTO> responsablesDTO = responsables.stream()
                    .<ResponsablesDeployDTO>map(resp -> {
                        var responsable = resp.getResponsable();
                        return ResponsablesDeployDTO.builder()
                            .id(responsable.getId())
                            .nombre(responsable.getNom()+" "+responsable.getApe())
                            .cargo(responsable.getCargo())
                            .build();
                    }).toList();

                    DeployResponseDTO deployDTO = DeployResponseDTO.builder()
                        .id(deploy.getId())
                        .version(deploy.getVersion())
                        .fechaRegistro(deploy.getFecha().atTime(deploy.getHoraIni()))
                        .tipoDeploy(deploy.getTipo().getNom())
                        .exitoso(deploy.getResultado())
                        .responsables(responsablesDTO)
                        .build();

                    proyectoDTO.getDeploys().add(deployDTO);
                }
            }
            

            proyectoResponses.add(proyectoDTO);
        }

        return proyectoResponses;
    }

    public ProyectoResponseDTO createProyecto(ProyectoCreateDTO proyectoDTO) { 

        Proyecto newProyecto = proyectoRepository.save(
            Proyecto.builder()
                .nombre(proyectoDTO.getNombre())
                .descripcion(proyectoDTO.getDescripcion())
                .fechaCreacion(proyectoDTO.getFechaCreacion())
                .build());

        return ProyectoResponseDTO.builder()
            .id(newProyecto.getId())
            .nombre(newProyecto.getNombre())
            .build();
    }

    public Proyecto getProyectoById(Long idProyecto) {
        return proyectoRepository.findById(idProyecto).orElseThrow(() -> new ResourceNotFoundException("Proyecto no encontrado"));
    }

}
