package com.back.back_reporte_deploy_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class PasosRollBack {

    @Id
    private Long id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_plan_rollback")
    private PlanRollback planRollback;
}
