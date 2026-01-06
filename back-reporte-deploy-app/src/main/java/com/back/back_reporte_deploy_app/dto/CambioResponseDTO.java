package com.back.back_reporte_deploy_app.dto;

import com.back.back_reporte_deploy_app.enums.TipoCambio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CambioResponseDTO {
    private Long id;
    private String descrip;
    private TipoCambio tipo;
    private Long idFeature;
}
