package com.back.back_reporte_deploy_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.entity.PasoDeploy;
import com.back.back_reporte_deploy_app.entity.ProcesoDeploy;
import com.back.back_reporte_deploy_app.repository.PasoDeployRepository;
import com.back.back_reporte_deploy_app.repository.ProcesoDeployRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProcesoDeployService {
    private final ProcesoDeployRepository procesoDeployRepository;
    private final PasoDeployRepository pasoDeployRepository;

    public ProcesoDeploy getProcesoDeployById(Long idProcesoDeploy) {
        return procesoDeployRepository.findById(idProcesoDeploy)
                .orElseThrow(() -> new RuntimeException("Proceso de Deploy no encontrado con ID: " + idProcesoDeploy));
    }

    public List<PasoDeploy> getPasosDeploysForIdProceDeploy(Long idProcesoDeploy) {
        return pasoDeployRepository.findByProcesoDeploy_Id(idProcesoDeploy);
    }
}
