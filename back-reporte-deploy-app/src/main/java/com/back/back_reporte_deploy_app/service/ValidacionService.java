package com.back.back_reporte_deploy_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.dto.ValidacionResponseDTO;
import com.back.back_reporte_deploy_app.entity.Deploy;
import com.back.back_reporte_deploy_app.entity.DetValidacion;
import com.back.back_reporte_deploy_app.entity.Validacion;
import com.back.back_reporte_deploy_app.repository.DetValidacionRepository;
import com.back.back_reporte_deploy_app.repository.ValidacionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ValidacionService {

    private final DetValidacionRepository detValidacionRepository;
    private final ValidacionRepository validacionRepository;

    public List<ValidacionResponseDTO> mapperValidacionesToResponse(List<Validacion> validaciones){
        return validaciones.stream()
                .map(valid -> ValidacionResponseDTO.builder()
                .id(valid.getId())
                .nombre(valid.getNom())
                .tipo(valid.getTipo())
                .build()).toList();
    }

    public List<Validacion> getValidacionForTipoDeploy(Long idTipoDeploy){
        return validacionRepository.findByDetValidTipoDeploysTipoId(idTipoDeploy);
    }

    public List<DetValidacion> insertDetalleValidacion(Deploy deploy, List<Validacion> validaciones){

        List<DetValidacion> listDetValidacion = new ArrayList<>() ;
        for (Validacion valid : validaciones){

            listDetValidacion.add(DetValidacion.builder()
                .deploy(deploy)
                .validacion(valid)
                .build());
        }

        detValidacionRepository.saveAll(listDetValidacion);

        return listDetValidacion;
    }

    public List<DetValidacion> getDetValidacionForDeploy(Long idDeploy){
        return detValidacionRepository.findByDeployId(idDeploy);
    }

}
