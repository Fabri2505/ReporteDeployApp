package com.back.back_reporte_deploy_app.entity;

import java.util.List;

import com.back.back_reporte_deploy_app.enums.TipoDeploy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcesoDeploy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TipoDeploy tipo;

    @OneToMany(mappedBy = "procesoDeploy")
    private List<PasoDeploy> pasos;
}
