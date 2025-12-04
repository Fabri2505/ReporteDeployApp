package com.back.back_reporte_deploy_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back_reporte_deploy_app.dto.ValidacionResponseDTO;
import com.back.back_reporte_deploy_app.service.ValidacionService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/validacion")
@RequiredArgsConstructor
public class ValidacionController {

    private final ValidacionService validacionService;

    @GetMapping("/{idTipoDeploy}")
    public List<ValidacionResponseDTO> getValidacionesForTipo(@PathVariable Long idTipoDeploy) {
        return validacionService.getValidacionForTipoDeploy(idTipoDeploy);
    }
    

}
