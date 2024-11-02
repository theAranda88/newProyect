package com.example.bdfirebase;

import androidx.annotation.NonNull;

public class Nitrito {
    private String codigoNitratoN;
    private String estadoN;
    private String valorMedidoN;

    public Nitrito() {
        // Constructor vacío requerido por Firebase
    }

    public Nitrito(String codigoNitratoN, String estadoN, String valorMedidoN) {
        this.codigoNitratoN = codigoNitratoN;
        this.estadoN = estadoN;
        this.valorMedidoN = valorMedidoN;
    }

    public String getCodigoNitratoN() {
        return codigoNitratoN;
    }

    public void setCodigoNitratoN(String codigoNitratoN) {
        this.codigoNitratoN = codigoNitratoN;
    }

    public String getEstadoN() {
        return estadoN;
    }

    public void setEstadoN(String estadoN) {
        this.estadoN = estadoN;
    }

    public String getValorMedidoN() {
        return valorMedidoN;
    }

    public void setValorMedidoN(String valorMedidoN) {
        this.valorMedidoN = valorMedidoN;
    }

    @NonNull
    @Override
    public String toString() {
        return "Nitrito{" +
                "codigoSensorH2o='" + estadoN + '\'' +
                ", valorMedidoH2o='" + valorMedidoN + '\'' +
                ", estadoH2o='" + codigoNitratoN + '\'' +
                '}';
    }
}
