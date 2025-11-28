package com.back.back_reporte_deploy_app.entity;

import java.util.List;

import com.back.back_reporte_deploy_app.enums.NivelRiesgo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Feature extends Deploy{
    
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private NivelRiesgo nivelRiesgo;
    
    private Integer downTime;
    private Integer tiempoIncidencia;

    @ManyToOne
    @JoinColumn(name = "id_plan_rollback")
    private PlanRollback planRollback;

    @OneToMany(mappedBy = "feature")
    private List<AreaAfectada> areasAfectadas;

    @OneToMany(mappedBy = "feature")
    private List<NewFuncionalidad> nuevasFuncionalidades;

    @OneToMany(mappedBy = "feature")
    private List<ComponenteDeploy> componentesDeploy;
    
    @OneToMany(mappedBy = "feature")
    private List<Notificacion> notificaciones;

    @OneToMany(mappedBy = "feature")
    private List<Incidente> incidentes;

    @OneToMany(mappedBy = "feature")
    private List<Cambio> cambios;

    @OneToMany(mappedBy = "feature")
    private List<DetDeploy> detDeploys;
}
