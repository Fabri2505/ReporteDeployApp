package com.back.back_reporte_deploy_app.dto;

import com.back.back_reporte_deploy_app.enums.TipoCambio;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CambioCreateDTO {
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descrip;
    @NotBlank(message = "El tipo de cambio no puede estar vacío")
    private TipoCambio tipo;
}
