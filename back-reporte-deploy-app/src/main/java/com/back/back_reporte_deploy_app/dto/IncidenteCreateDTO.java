package com.back.back_reporte_deploy_app.dto;

import com.back.back_reporte_deploy_app.enums.NivelIncidencia;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncidenteCreateDTO {
    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 255, message = "La descripción no puede exceder 255 caracteres")
    private String descripcion;
    
    @NotBlank(message = "La resolución es obligatoria")
    @Size(max = 255, message = "La resolución no puede exceder 255 caracteres")
    private String resolucion;
    
    @NotNull(message = "El nivel de incidencia es obligatorio")
    private NivelIncidencia nivelIncidencia;
    
    @NotNull(message = "El tiempo de resolución es obligatorio")
    @Min(value = 0, message = "El tiempo de resolución no puede ser negativo")
    private Integer tiempoResolucionMinutos;
}
