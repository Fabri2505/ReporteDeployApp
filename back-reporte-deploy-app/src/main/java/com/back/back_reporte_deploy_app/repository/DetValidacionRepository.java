package com.back.back_reporte_deploy_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back_reporte_deploy_app.entity.DetValidacion;

@Repository
public interface DetValidacionRepository extends JpaRepository<DetValidacion, Long> {

}
