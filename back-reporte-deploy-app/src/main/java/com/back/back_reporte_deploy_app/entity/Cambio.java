package com.back.back_reporte_deploy_app.entity;

import com.back.back_reporte_deploy_app.enums.TipoCambio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descrip;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TipoCambio tipo;

    @ManyToOne
    @JoinColumn(name = "id_feature")
    private Feature feature;
}
