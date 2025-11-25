package com.back.back_reporte_deploy_app.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;

@Data
@Entity
public class AreaAfectada {

    @EmbeddedId
    private AreaAfectadaId id;

    private Integer cantUsuAfectados;

    @ManyToOne
    @MapsId("area")
    @JoinColumn(name = "id_area")
    private Area area;

    @ManyToOne
    @MapsId("feature")
    @JoinColumn(name = "id_feature")
    private Feature feature;
}
