package com.back.back_reporte_deploy_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.back.back_reporte_deploy_app.entity.DetValidacion;

@Repository
public interface DetValidacionRepository extends JpaRepository<DetValidacion, Long> {
    @Query("SELECT dv FROM DetValidacion dv JOIN FETCH dv.validacion WHERE dv.deploy.id = :id")
    public List<DetValidacion> findByDeployId(Long id);
}
