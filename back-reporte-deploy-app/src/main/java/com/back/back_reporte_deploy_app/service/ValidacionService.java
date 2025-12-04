package com.back.back_reporte_deploy_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.dto.ValidacionResponseDTO;
import com.back.back_reporte_deploy_app.repository.ValidacionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ValidacionService {
    private final ValidacionRepository validacionRepository;

    public List<ValidacionResponseDTO> getValidacionForTipoDeploy(Long idTipoDeploy){
        return validacionRepository.findByDetValidTipoDeploysTipoId(idTipoDeploy).stream()
                .map(valid -> ValidacionResponseDTO.builder()
                .id(valid.getId())
                .nombre(valid.getNom())
                .tipo(valid.getTipo())
                .build()).toList();
    }
}
