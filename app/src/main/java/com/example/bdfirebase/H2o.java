package com.example.bdfirebase;

import androidx.annotation.NonNull;

public class H2o {
    private String codigoSensorH2o;
    private String estadoH2o;
    private String valorMedidoH2o;

    public H2o() {
    }

    public H2o(String codigoSensorH2o, String estadoH2o, String valorMedidoH2o) {
        this.codigoSensorH2o = codigoSensorH2o;
        this.estadoH2o = estadoH2o;
        this.valorMedidoH2o = valorMedidoH2o;
    }

    public String getCodigoSensorH2o() {
        return codigoSensorH2o;
    }

    public void setCodigoSensorH2o(String codigoSensorH2o) {
        this.codigoSensorH2o = codigoSensorH2o;
    }

    public String getEstadoH2o() {
        return estadoH2o;
    }

    public void setEstadoH2o(String estadoH2o) {
        this.estadoH2o = estadoH2o;
    }

    public String getValorMedidoH2o() {
        return valorMedidoH2o;
    }

    public void setValorMedidoH2o(String valorMedidoH2o) {
        this.valorMedidoH2o = valorMedidoH2o;
    }

    @NonNull
    @Override
    public String toString() {
        return  "H2o{" +
                "codigoSensorH2o='" + codigoSensorH2o + '\'' +
                ", valorMedidoH2o='" + valorMedidoH2o + '\'' +
                ", estadoH2o='" + estadoH2o + '\'' +
                '}';
    }
}
