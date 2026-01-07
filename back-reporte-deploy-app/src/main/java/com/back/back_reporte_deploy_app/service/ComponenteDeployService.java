package com.back.back_reporte_deploy_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.dto.ComponenteDeployCreateDTO;
import com.back.back_reporte_deploy_app.dto.ComponenteDeployResponseDTO;
import com.back.back_reporte_deploy_app.entity.ComponenteDeploy;
import com.back.back_reporte_deploy_app.entity.Feature;
import com.back.back_reporte_deploy_app.repository.ComponenteDeployRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComponenteDeployService {
    private final ComponenteDeployRepository componenteDeployRepository;

    public List<ComponenteDeployResponseDTO> crearComponentes(
            List<ComponenteDeployCreateDTO> componentesDTO, 
            Feature feature) {
        
        List<ComponenteDeploy> componentes = componentesDTO.stream()
            .map(dto -> ComponenteDeploy.builder()
                .descrip(dto.getDescrip())
                .feature(feature)
                .build())
            .toList();
        
        componentes = componenteDeployRepository.saveAll(componentes);

        return componentes.stream()
            .map(comp -> ComponenteDeployResponseDTO.builder()
                .id(comp.getId())
                .descrip(comp.getDescrip())
                .idFeature(comp.getFeature().getId())
                .build())
            .toList();
    }

}
