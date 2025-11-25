package com.back.back_reporte_deploy_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.dto.ProyectoResponseDTO;
import com.back.back_reporte_deploy_app.repository.ProyectoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProyectoService {
    private final ProyectoRepository proyectoRepository;

    public List<ProyectoResponseDTO> getProyectos() {

        return proyectoRepository.findAll().stream().map(proyecto -> ProyectoResponseDTO.builder()
            .id(proyecto.getId())
            .nombre(proyecto.getNombre())
            .build()).toList();
            
    }

}
