package com.back.back_reporte_deploy_app.dto;

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
    private String version;
    private String fechaDeploy;
    private List<ResponsablesDeployDTO> responsables;
}
