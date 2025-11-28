package com.back.back_reporte_deploy_app.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.back.back_reporte_deploy_app.enums.TipoDeploy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeployCreateDTO {
    private String version;
    private LocalDateTime fechaDeploy;
    private Long idProyecto;
    private String sprint;
    private TipoDeploy tipoDeploy;
    private DeployFeatureCreateDTO feature;
    private List<Long> idResponsables;
    private Long idProcesoDespliegue;
}
