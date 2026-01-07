package com.back.back_reporte_deploy_app.dto;

import com.back.back_reporte_deploy_app.enums.NivelIncidencia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncidenteResponseDTO {
    private Long id;
    private String descripcion;
    private String resolucion;
    private NivelIncidencia nivelIncidencia;
    private Integer tiempoResolucionMinutos;
    private Long idFeature;
}
