package com.back.back_reporte_deploy_app.enums;

public enum TipoCambio {
    BACK("Back-End"),
    FRONT("Front-End"),
    BD("Bases de Datos");

    private final String tipo;

    TipoCambio(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
