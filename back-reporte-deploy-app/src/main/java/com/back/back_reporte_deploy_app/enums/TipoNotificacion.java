package com.back.back_reporte_deploy_app.enums;

public enum TipoNotificacion {
    EMAIL("EMAIL"),
    SMS("SMS"),
    PUSH_NOTIFICATION("PUSH_NOTIFICATION");

    private final String tipo;

    TipoNotificacion(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
