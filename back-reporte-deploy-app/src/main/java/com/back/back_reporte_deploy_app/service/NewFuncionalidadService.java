package com.back.back_reporte_deploy_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.dto.NewFuncionalidadCreateDTO;
import com.back.back_reporte_deploy_app.dto.NewFuncionalidadResponseDTO;
import com.back.back_reporte_deploy_app.entity.Feature;
import com.back.back_reporte_deploy_app.entity.NewFuncionalidad;
import com.back.back_reporte_deploy_app.repository.NewFuncionalidadRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewFuncionalidadService {
    private final NewFuncionalidadRepository newFuncionalidadRepository;

    public List<NewFuncionalidadResponseDTO> crearFuncionalidades(
            List<NewFuncionalidadCreateDTO> funcionalidadesDTO, 
            Feature feature) {
        
        List<NewFuncionalidad> funcionalidades = funcionalidadesDTO.stream()
            .map(dto -> NewFuncionalidad.builder()
                .descrip(dto.getDescrip())
                .feature(feature)
                .build())
            .toList();
        
        funcionalidades = newFuncionalidadRepository.saveAll(funcionalidades);

        return funcionalidades.stream()
            .map(func -> NewFuncionalidadResponseDTO.builder()
                .id(func.getId())
                .descrip(func.getDescrip())
                .idFeature(func.getFeature().getId())
                .build())
            .toList();
    }

}
