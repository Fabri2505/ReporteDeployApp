package com.back.back_reporte_deploy_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back_reporte_deploy_app.dto.ProyectoResponseDTO;
import com.back.back_reporte_deploy_app.service.ProyectoService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/proyectos")
@RequiredArgsConstructor
public class ProyectoController {
    private final ProyectoService proyectoService;

    @GetMapping("")
    public ResponseEntity<List<ProyectoResponseDTO>> getProyectos() {
        List<ProyectoResponseDTO> proyectos = proyectoService.getProyectos();

        return ResponseEntity.ok(proyectos);
    }
    
}
