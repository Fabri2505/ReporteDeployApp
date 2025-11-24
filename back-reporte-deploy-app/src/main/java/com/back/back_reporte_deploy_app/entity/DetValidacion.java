package com.back.back_reporte_deploy_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class DetValidacion {
    @Id
    private Long id;

    private Boolean hecho;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_validacion")
    private Validacion validacion;

    @ManyToOne
    @JoinColumn(name = "id_deploy")
    private Deploy deploy;

}
