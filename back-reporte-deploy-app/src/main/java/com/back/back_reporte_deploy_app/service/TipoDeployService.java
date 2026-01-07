package com.back.back_reporte_deploy_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.entity.TipoDeploy;
import com.back.back_reporte_deploy_app.exceptions.ResourceNotFoundException;
import com.back.back_reporte_deploy_app.repository.TipoDeployRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoDeployService {
    private final TipoDeployRepository tipoDeployRepository;

    public List<TipoDeploy> findAllTipos(){
        return tipoDeployRepository.findAll();
    }

    public TipoDeploy getTipoDeployForId(Long id){
        return tipoDeployRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TipoDeploy no encontrado"));
    }
}
