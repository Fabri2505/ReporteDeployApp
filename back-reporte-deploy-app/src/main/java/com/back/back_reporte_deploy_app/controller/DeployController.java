package com.back.back_reporte_deploy_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back_reporte_deploy_app.dto.CambioCreateDTO;
import com.back.back_reporte_deploy_app.dto.CambioResponseDTO;
import com.back.back_reporte_deploy_app.dto.DeployCreateDTO;
import com.back.back_reporte_deploy_app.dto.DeployResponseDTO;
import com.back.back_reporte_deploy_app.dto.ValidacionDeployResponseDTO;
import com.back.back_reporte_deploy_app.service.DeployService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/deploy")
@RequiredArgsConstructor
public class DeployController {

    private final DeployService deployService;
    
    @PostMapping("")
    public ResponseEntity<DeployResponseDTO> registerDeploy(@RequestBody DeployCreateDTO deployRegister) {
        DeployResponseDTO deploy = deployService.registerDeploy(deployRegister);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(deploy);
    }

    @GetMapping("/validacion/{idDeploy}")
    public ResponseEntity<List<ValidacionDeployResponseDTO>> getValidacionesForDeploy(@PathVariable Long idDeploy) {

        List<ValidacionDeployResponseDTO> validaciones = deployService.getValidaciones(idDeploy);

        return ResponseEntity.ok(validaciones);
    }
    
    @PostMapping("/cambios/{idDeploy}")
    public ResponseEntity<List<CambioResponseDTO>> asignarCambiosRealizados(@PathVariable Long idDeploy, @RequestBody List<CambioCreateDTO> cambios) {
        
        var cambiosResponse = deployService.asignarCambios(idDeploy, cambios);

        return ResponseEntity.status(HttpStatus.CREATED).body(cambiosResponse);
    }
    
    
}
