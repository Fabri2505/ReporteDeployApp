package com.back.back_reporte_deploy_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidacionDeployResponseDTO {
    private Long id;
    private String nomValidacion;
    private Boolean hecho;
    private String comentario;
}
