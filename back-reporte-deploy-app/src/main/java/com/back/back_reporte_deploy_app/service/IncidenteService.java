package com.back.back_reporte_deploy_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.dto.IncidenteCreateDTO;
import com.back.back_reporte_deploy_app.dto.IncidenteResponseDTO;
import com.back.back_reporte_deploy_app.entity.Feature;
import com.back.back_reporte_deploy_app.entity.Incidente;
import com.back.back_reporte_deploy_app.repository.IncidenteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IncidenteService {
    private final IncidenteRepository incidenteRepository;

    public List<IncidenteResponseDTO> crearIncidentes(
            List<IncidenteCreateDTO> incidentesDTO, 
            Feature feature) {
        
        List<Incidente> incidentes = incidentesDTO.stream()
            .map(dto -> Incidente.builder()
                .descripcion(dto.getDescripcion())
                .resolucion(dto.getResolucion())
                .nivelIncidencia(dto.getNivelIncidencia())
                .tiempoResolucionMinutos(dto.getTiempoResolucionMinutos())
                .feature(feature)
                .build())
            .toList();
        
        incidentes = incidenteRepository.saveAll(incidentes);

        return incidentes.stream()
            .map(inc -> IncidenteResponseDTO.builder()
                .id(inc.getId())
                .descripcion(inc.getDescripcion())
                .resolucion(inc.getResolucion())
                .nivelIncidencia(inc.getNivelIncidencia())
                .tiempoResolucionMinutos(inc.getTiempoResolucionMinutos())
                .idFeature(inc.getFeature().getId())
                .build())
            .toList();
    }
}
