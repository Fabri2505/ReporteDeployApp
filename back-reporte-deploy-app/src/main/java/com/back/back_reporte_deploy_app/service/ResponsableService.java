package com.back.back_reporte_deploy_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.entity.DetRespDeploy;
import com.back.back_reporte_deploy_app.entity.Responsable;
import com.back.back_reporte_deploy_app.repository.DetRespDeployRepository;
import com.back.back_reporte_deploy_app.repository.ResponsableRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResponsableService {
    private final ResponsableRepository responsableRepository;
    private final DetRespDeployRepository detRespDeployRepository;

    public List<Responsable> getResponsablesByIds(List<Long> idResponsables) {
        return responsableRepository.findByIdIn(idResponsables);
    }

    public void saveAllDetRespDeploys(List<DetRespDeploy> detRespDeploys) {
        detRespDeployRepository.saveAll(detRespDeploys);
    }
}
