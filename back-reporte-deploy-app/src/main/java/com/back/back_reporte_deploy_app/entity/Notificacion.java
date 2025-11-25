package com.back.back_reporte_deploy_app.entity;

import java.time.LocalDateTime;

import com.back.back_reporte_deploy_app.enums.TipoNotificacion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TipoNotificacion tipo;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "id_feature")
    private Feature feature;
}
