package com.back.back_reporte_deploy_app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.back_reporte_deploy_app.dto.ProyectoCreateDTO;
import com.back.back_reporte_deploy_app.dto.ProyectoResponseDTO;
import com.back.back_reporte_deploy_app.service.ProyectoService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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

    @PostMapping("")
    public ResponseEntity<ProyectoResponseDTO> createProyecto(@RequestBody ProyectoCreateDTO proyectoDTO) {
        
        ProyectoResponseDTO proyecto = proyectoService.createProyecto(proyectoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(proyecto);

    }
    
}
