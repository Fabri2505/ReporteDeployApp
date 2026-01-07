package com.back.back_reporte_deploy_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.dto.BugCreateDTO;
import com.back.back_reporte_deploy_app.dto.BugResponseDTO;
import com.back.back_reporte_deploy_app.entity.Bug;
import com.back.back_reporte_deploy_app.entity.Deploy;
import com.back.back_reporte_deploy_app.repository.BugRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BugService {
    private final BugRepository bugRepository;

    public List<BugResponseDTO> agregarBugs(List<BugCreateDTO> bugsDto, Deploy deploy) {
        List<Bug> bugs = bugsDto.stream().map(dto -> Bug.builder()
                .descrip(dto.getDescripcion())
                .nomBug(dto.getTitulo())
                .impacto(dto.getImpacto())
                .solucion(dto.getSolucion())
                .deploy(deploy)
                .build()
            ).toList();

        bugs = bugRepository.saveAll(bugs);
        return bugs.stream().map(b -> BugResponseDTO.builder()
                .id(b.getId())
                .titulo(b.getNomBug())
                .descripcion(b.getDescrip())
                .impacto(b.getImpacto())
                .solucion(b.getSolucion())
                .idDeploy(b.getDeploy().getId())
                .build()
            ).toList();
    }

}
