package com.back.back_reporte_deploy_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BugCreateDTO {
    private String titulo;
    private String descripcion;
    private String impacto;
    private String solucion;
}
