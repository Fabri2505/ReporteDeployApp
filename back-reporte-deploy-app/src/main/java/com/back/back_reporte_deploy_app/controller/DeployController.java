package com.back.back_reporte_deploy_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back_reporte_deploy_app.dto.DeployCreateDTO;
import com.back.back_reporte_deploy_app.dto.DeployResponseDTO;
import com.back.back_reporte_deploy_app.service.DeployService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
    
}
