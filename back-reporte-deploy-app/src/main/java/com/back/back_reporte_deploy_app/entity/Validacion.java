package com.back.back_reporte_deploy_app.entity;

import com.back.back_reporte_deploy_app.enums.TipoValidacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Validacion {
    @Id
    private Long id;

    private String nom;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TipoValidacion tipo;

    
}
