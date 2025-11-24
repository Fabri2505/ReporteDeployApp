package com.back.back_reporte_deploy_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class DetRespDeploy {
    @ManyToOne
    @JoinColumn(name = "id_responsable")
    private Responsable responsable;

    @ManyToOne
    @JoinColumn(name = "id_deploy")
    private Deploy deploy;

    private String puesto;
}
