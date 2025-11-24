package com.back.back_reporte_deploy_app.entity;

import java.time.LocalDateTime;

import com.back.back_reporte_deploy_app.enums.TipoBackup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Backup {
    @Id
    private Long id;

    private LocalDateTime fechaBackup;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TipoBackup tipoBackup;

    
}
