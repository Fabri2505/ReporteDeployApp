package com.back.back_reporte_deploy_app.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40)
    private String nom;

    @Column(length = 40)
    private String ape; 
    
    @Column(length = 40)
    private String cargo;

    @OneToMany(mappedBy = "responsable")
    @Builder.Default
    private List<DetRespDeploy> detRespDeploys = new ArrayList<>();

    @OneToMany(mappedBy = "responsable")
    @Builder.Default
    private List<Backup> backups = new ArrayList<>();
}
