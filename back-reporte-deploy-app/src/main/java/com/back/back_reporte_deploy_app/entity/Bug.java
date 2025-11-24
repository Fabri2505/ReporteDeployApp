package com.back.back_reporte_deploy_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Bug {
    @Id
    private Long id;

    @Column(length = 20)
    private String nomBug;
    @Column(length = 300)
    private String descrip;
    @Column(length = 250)
    private String impacto;
    @Column(length = 300)
    private String solucion;

    @ManyToOne
    @JoinColumn(name = "id_deploy")
    private Deploy deploy;
}
