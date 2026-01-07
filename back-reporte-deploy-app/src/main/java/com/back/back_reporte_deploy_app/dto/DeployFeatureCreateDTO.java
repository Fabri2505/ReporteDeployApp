package com.back.back_reporte_deploy_app.dto;

import java.util.List;

import com.back.back_reporte_deploy_app.enums.NivelRiesgo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeployFeatureCreateDTO {
    private NivelRiesgo nivelRiesgo;
    private Integer downTime;
    private List<AreaAfectadaCreateDTO> areasAfectadas;
}
