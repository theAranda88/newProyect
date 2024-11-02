package com.example.bdfirebase;

import androidx.annotation.NonNull;

public class Temperatura {
    private String codigoSensorT;
    private String estadoT;
    private String valorMedidoT;


    public Temperatura() {
    }

    public Temperatura(String codigoSensorT, String estadoT, String valorMedidoT) {
        this.codigoSensorT = codigoSensorT;
        this.estadoT = estadoT;
        this.valorMedidoT = valorMedidoT;
    }

    public String getCodigoSensorT() {
        return codigoSensorT;
    }

    public void setCodigoSensorT(String codigoSensorT) {
        this.codigoSensorT = codigoSensorT;
    }

    public String getEstadoT() {
        return estadoT;
    }

    public void setEstadoT(String estadoT) {
        this.estadoT = estadoT;
    }

    public String getValorMedidoT() {
        return valorMedidoT;
    }

    public void setValorMedidoT(String valorMedidoT) {
        this.valorMedidoT = valorMedidoT;
    }

    @NonNull
    @Override
    public String toString() {
        return "Temperatura{" +
                "estadoH2o='" + estadoT + '\'' +
                ", valorMedidoH2o='" + valorMedidoT + '\'' +
                ", codigoSensorH2o='" + codigoSensorT + '\'' +
                '}';
    }
}
