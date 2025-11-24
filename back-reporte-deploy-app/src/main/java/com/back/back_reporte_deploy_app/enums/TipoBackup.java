package com.back.back_reporte_deploy_app.enums;

public enum TipoBackup {
    BD("Base de Datos"),
    ARCHIVOS("Archivos"),
    COMPLETO("Completo");

    private final String descripcion;

    TipoBackup(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
