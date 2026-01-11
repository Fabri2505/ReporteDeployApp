package com.back.back_reporte_deploy_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.back.back_reporte_deploy_app.entity.Area;

@RepositoryRestResource(path = "areas", collectionResourceRel = "areas", itemResourceRel = "area")
public interface AreaRepository extends JpaRepository<Area, Long> {

}
