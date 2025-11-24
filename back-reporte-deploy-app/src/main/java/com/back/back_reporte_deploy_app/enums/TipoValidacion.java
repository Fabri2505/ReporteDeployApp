package com.back.back_reporte_deploy_app.enums;

public enum TipoValidacion {
    PREVALID("Prevalidación"),
    POSTVALID("Postvalidación"),
    DOCUMENTACION("Documentación");

    private final String descripcion;

    TipoValidacion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
