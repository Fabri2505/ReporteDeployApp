package com.back.back_reporte_deploy_app.service;

import org.springframework.stereotype.Service;

import com.back.back_reporte_deploy_app.entity.PlanRollback;
import com.back.back_reporte_deploy_app.repository.PlanRollBackRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanRollBackService {
    private final PlanRollBackRepository planRollBackRepository;

    public PlanRollback getPlanRollbackById(Long idPlanRollback) {
        return planRollBackRepository.findById(idPlanRollback)
                .orElseThrow(() -> new RuntimeException("Plan de Rollback no encontrado con ID: " + idPlanRollback));
    }
}
