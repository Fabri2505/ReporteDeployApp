package com.back.back_reporte_deploy_app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class PasoDeploy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descrip;

    @ManyToOne
    @JoinColumn(name = "id_proceso_deploy")
    private ProcesoDeploy procesoDeploy;

    @OneToMany(mappedBy = "pasoDeploy")
    private List<DetDeploy> detDeploys;
}
