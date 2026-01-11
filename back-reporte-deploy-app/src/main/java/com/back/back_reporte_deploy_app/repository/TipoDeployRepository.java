package com.back.back_reporte_deploy_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.back.back_reporte_deploy_app.entity.TipoDeploy;

@RepositoryRestResource(path = "tipo-deploy")
public interface TipoDeployRepository extends JpaRepository<TipoDeploy, Long>{

}
