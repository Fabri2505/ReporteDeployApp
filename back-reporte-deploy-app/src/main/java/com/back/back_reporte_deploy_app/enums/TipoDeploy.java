package com.back.back_reporte_deploy_app.enums;

public enum TipoDeploy {
    MAJOR("Despliegue Mayor"),
    MINOR("Despliegue Menor"),
    PATCH("Despliegue de Parche");

    private final String descripcion;

    TipoDeploy(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
