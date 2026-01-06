package com.back.back_reporte_deploy_app.dto;

import com.back.back_reporte_deploy_app.enums.TipoValidacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidacionResponseDTO {
    private Long id;
    private String nombre;
    private TipoValidacion tipo;
}
