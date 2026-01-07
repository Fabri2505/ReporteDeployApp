package com.back.back_reporte_deploy_app.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.dto.AreaAfectadaCreateDTO;
import com.back.back_reporte_deploy_app.entity.Area;
import com.back.back_reporte_deploy_app.entity.AreaAfectada;
import com.back.back_reporte_deploy_app.entity.AreaAfectadaId;
import com.back.back_reporte_deploy_app.entity.Feature;
import com.back.back_reporte_deploy_app.exceptions.ResourceNotFoundException;
import com.back.back_reporte_deploy_app.repository.AreaAfectadaRepository;
import com.back.back_reporte_deploy_app.repository.AreaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AreaService {
    private final AreaRepository areaRepository;
    private final AreaAfectadaRepository areaAfectRepository;

    private Area getAreaById(Long id) {
        return areaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Area no encontrada con id: " + id));
    }

    public List<AreaAfectada> asignAreasAfectadasToFeature(List<AreaAfectadaCreateDTO> areaDto, Feature feature) {
        
        List<AreaAfectada> areasAfectEntity = new ArrayList<>();

        for (var area : areaDto ) {
            var areaId = AreaAfectadaId.builder()
                .area(area.getIdArea())
                .feature(feature.getId())
                .build();

            areasAfectEntity.add(AreaAfectada.builder()
                .id(areaId)
                .area(getAreaById(area.getIdArea()))
                .feature(feature)
                .cantUsuAfectados(area.getCantUsuAfectados())
                .build());
        }
        
        return areaAfectRepository.saveAll(areasAfectEntity);
        
    }
}
