package com.back.back_reporte_deploy_app.enums;

public enum NivelIncidencia {
    BAJA("Baja"),
    MEDIA("Media"),
    ALTA("Alta");

    private final String descripcion;

    NivelIncidencia(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
