package com.back.back_reporte_deploy_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsablesDeployDTO {
    private Long id;
    private String nombre; 
    private String cargo; 
}
