package com.back.back_reporte_deploy_app.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Responsable {
    @Id
    private Long id;

    @Column(length = 40)
    private String nom;

    @Column(length = 40)
    private String ape; 
    
    @Column(length = 40)
    private String cargo;

    @OneToMany(mappedBy = "responsable")
    private List<DetRespDeploy> detRespDeploys;

    @OneToMany(mappedBy = "responsable")
    private List<Backup> backups;
}
