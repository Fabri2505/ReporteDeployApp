package com.back.back_reporte_deploy_app.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetRespDeploy {

    @EmbeddedId
    private DetRespDeployId id;

    @ManyToOne
    @MapsId("responsable")
    @JoinColumn(name = "id_responsable")
    private Responsable responsable;

    @ManyToOne
    @MapsId("deploy")
    @JoinColumn(name = "id_deploy")
    private Deploy deploy;

    private String puesto;
}
