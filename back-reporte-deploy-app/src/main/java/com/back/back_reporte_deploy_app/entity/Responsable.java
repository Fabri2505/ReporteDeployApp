package com.back.back_reporte_deploy_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Responsable {
    @Id
    private Long id;

    @Column(length = 40)
    private String nom;

    @Column(length = 40)
    private String ape; 
    
    @Column(length = 40)
    private String cargo;
}
