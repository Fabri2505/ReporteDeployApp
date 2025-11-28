package com.back.back_reporte_deploy_app.enums;

public enum NivelRiesgo {
    CRITICO("Crítico"),
    ALTO("Alto"),
    MEDIO("Medio"),
    BAJO("Bajo");

    private final String descripcion;

    NivelRiesgo(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
