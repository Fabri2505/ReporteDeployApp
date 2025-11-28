package com.back.back_reporte_deploy_app.service;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.repository.DeployRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeployService {
    private final DeployRepository deployRepository;

    public String registerDeploy() {
        // Lógica para registrar el despliegue
        return "Despliegue registrado exitosamente";
    }
}
