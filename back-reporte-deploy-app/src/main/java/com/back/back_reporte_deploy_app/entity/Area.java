package com.back.back_reporte_deploy_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Area {
    @Id
    private Long id;

    private String nombre;
}
