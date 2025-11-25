package com.back.back_reporte_deploy_app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Area {
    @Id
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "area")
    private List<AreaAfectada> areasAfectadas;
}
