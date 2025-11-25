package com.back.back_reporte_deploy_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Feature extends Deploy{
    
    private String nivelRiesgo;
    private Integer downTime;
    private Integer tiempoIncidencia;

    @ManyToOne
    @JoinColumn(name = "id_plan_rollback")
    private PlanRollback planRollback;

    @ManyToOne
    @JoinColumn(name = "id_deploy")
    private Deploy deploy;
}
