package com.back.back_reporte_deploy_app.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class DetDeployId implements Serializable{
    private Long pasoDeploy;
    private Long feature;
}
