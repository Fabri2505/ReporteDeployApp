package com.back.back_reporte_deploy_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.dto.CambioCreateDTO;
import com.back.back_reporte_deploy_app.dto.CambioResponseDTO;
import com.back.back_reporte_deploy_app.entity.Cambio;
import com.back.back_reporte_deploy_app.entity.Feature;
import com.back.back_reporte_deploy_app.repository.CambioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CambioService {
    private final CambioRepository cambioRepository;

    public List<CambioResponseDTO> crearCambios(List<CambioCreateDTO> cambiosDTO, Feature feature) {
        List<Cambio> cambios = cambiosDTO.stream()
            .map(dto -> Cambio.builder()
                .descrip(dto.getDescrip())
                .tipo(dto.getTipo())
                .feature(feature)
                .build())
            .toList();
        
        cambios = cambioRepository.saveAll(cambios);

        return cambios.stream().map((cam)->CambioResponseDTO.builder()
            .id(cam.getId())
            .descrip(cam.getDescrip())
            .tipo(cam.getTipo())
            .idFeature(cam.getFeature().getId())
            .build()).toList();
    }

}
