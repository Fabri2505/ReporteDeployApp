package com.back.back_reporte_deploy_app.entity;

import java.time.LocalDateTime;

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
public class DetDeploy {

    @EmbeddedId
    private DetDeployId id;

    @ManyToOne
    @MapsId("pasoDeploy")
    @JoinColumn(name = "id_paso_deploy")
    private PasoDeploy pasoDeploy;

    @ManyToOne
    @MapsId("feature")
    @JoinColumn(name = "id_feature")
    private Feature feature;

    private LocalDateTime fecHora;
}
