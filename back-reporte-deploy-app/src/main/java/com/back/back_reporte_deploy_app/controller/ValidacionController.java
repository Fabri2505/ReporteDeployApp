package com.back.back_reporte_deploy_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back_reporte_deploy_app.dto.DetValidUpdateDTO;
import com.back.back_reporte_deploy_app.dto.ValidacionDeployResponseDTO;
import com.back.back_reporte_deploy_app.dto.ValidacionResponseDTO;
import com.back.back_reporte_deploy_app.service.ValidacionService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/validacion")
@RequiredArgsConstructor
public class ValidacionController {

    private final ValidacionService validacionService;

    @GetMapping("/tipo/{idTipoDeploy}")
    public ResponseEntity<List<ValidacionResponseDTO>> getValidacionesForTipo(@PathVariable Long idTipoDeploy) {

        return ResponseEntity.ok(validacionService.mapperValidacionesToResponse(
            validacionService.getValidacionForTipoDeploy(idTipoDeploy)
        ));
    }

    @PutMapping("detalle-deploy")
    public ResponseEntity<List<ValidacionDeployResponseDTO>> putDetalleDeploy(@RequestBody List<DetValidUpdateDTO> updateDetValid) {

        List<ValidacionDeployResponseDTO> validsResponse = validacionService.updateDetValidForDeploy(updateDetValid);

        return ResponseEntity.ok(validsResponse);

    }
    
}
