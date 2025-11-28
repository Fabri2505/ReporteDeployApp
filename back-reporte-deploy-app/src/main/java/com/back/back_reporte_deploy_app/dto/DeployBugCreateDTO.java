package com.back.back_reporte_deploy_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeployBugCreateDTO {
    private String descripcion;
    private String impacto;
    private String nomBug;
    private String solucion;
}
