package com.back.back_reporte_deploy_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back_reporte_deploy_app.entity.TipoDeploy;

@Repository
public interface TipoDeployRepository extends JpaRepository<TipoDeploy, Long>{

}
