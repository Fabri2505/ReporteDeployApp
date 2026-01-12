package com.back.back_reporte_deploy_app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
public class TipoDeploy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "tipo")
    @Builder.Default
    private List<Deploy> deploys = new ArrayList<>();

    @OneToMany(mappedBy = "tipo")
    @Builder.Default
    private List<ProcesoDeploy> procesodeploys = new ArrayList<>();

    @OneToMany(mappedBy = "tipo")
    @Builder.Default
    private List<DetValidacionTipoDeploy> detValidTipoDeploys = new ArrayList<>();
}
