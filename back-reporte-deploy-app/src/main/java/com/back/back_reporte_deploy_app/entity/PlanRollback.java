package com.back.back_reporte_deploy_app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class PlanRollback {
    @Id
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "planRollback")
    private List<PasosRollBack> pasosRollBacks;

    @OneToMany(mappedBy = "planRollback")
    private List<Feature> features;
}
