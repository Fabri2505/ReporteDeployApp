package com.back.back_reporte_deploy_app.entity;

import java.time.LocalDateTime;

import com.back.back_reporte_deploy_app.enums.TipoBackup;

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
public class Backup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fechaBackup;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TipoBackup tipoBackup;

    @ManyToOne
    @JoinColumn(name = "id_deploy")
    private Deploy deploy;
    
    @ManyToOne
    @JoinColumn(name = "id_responsable")
    private Responsable responsable;
}
