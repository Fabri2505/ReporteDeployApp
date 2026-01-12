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
@NoArgsConstructor
@AllArgsConstructor
public class PlanRollback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "planRollback")
    @Builder.Default
    private List<PasosRollBack> pasosRollBacks = new ArrayList<>();

    @OneToMany(mappedBy = "planRollback")
    @Builder.Default
    private List<Feature> features = new ArrayList<>();
}
