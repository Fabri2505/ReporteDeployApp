package com.back.back_reporte_deploy_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back_reporte_deploy_app.entity.PasoDeploy;

@Repository
public interface PasoDeployRepository extends JpaRepository<PasoDeploy, Long> {
    List<PasoDeploy> findByProcesoDeploy_Id(Long idProcesoDeploy);
}
