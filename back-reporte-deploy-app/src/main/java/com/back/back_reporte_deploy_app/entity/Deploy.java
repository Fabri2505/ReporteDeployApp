package com.back.back_reporte_deploy_app.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Deploy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String version;

    @ManyToOne
    @JoinColumn(name = "id_tipo_deploy")
    private TipoDeploy tipo;

    private LocalDate fecha;
    private LocalTime horaIni;
    private LocalTime horaFin;
    private LocalTime horaFinReal;
    private String sprint;
    private String rutaReporte;
    private Boolean resultado;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;
    
    @OneToMany(mappedBy = "deploy")
    @Builder.Default
    private List<Bug> bugs = new ArrayList<>();

    @OneToMany(mappedBy = "deploy")
    @Builder.Default
    private List<DetRespDeploy> detRespDeploys = new ArrayList<>();

    @OneToMany(mappedBy = "deploy")
    @Builder.Default
    private List<DetValidacion> detValidaciones = new ArrayList<>();

    @OneToMany(mappedBy = "deploy")
    @Builder.Default
    private List<Backup> backups = new ArrayList<>();
    
}
