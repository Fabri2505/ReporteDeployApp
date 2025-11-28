package com.back.back_reporte_deploy_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.back_reporte_deploy_app.entity.Responsable;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Long> {
    List<Responsable> findByIdIn(List<Long> ids);
}
