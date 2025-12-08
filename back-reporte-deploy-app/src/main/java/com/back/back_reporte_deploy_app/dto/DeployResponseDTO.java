package com.back.back_reporte_deploy_app.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeployResponseDTO {
    private Long id;
    private String version;
    private LocalDateTime fechaRegistro;
    private String tipoDeploy;
    private List<ResponsablesDeployDTO> responsables;
}
