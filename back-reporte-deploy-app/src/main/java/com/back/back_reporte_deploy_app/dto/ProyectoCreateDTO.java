package com.back.back_reporte_deploy_app.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoCreateDTO {
    private String nombre; 
    private String descripcion;
    private LocalDateTime fechaCreacion;
}
