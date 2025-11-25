package com.back.back_reporte_deploy_app.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AreaAfectadaId implements Serializable{
    private Long area;
    private Long feature;
}
