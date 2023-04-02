package com.app.entidades;

import java.util.ArrayList;

public class CuentaCorriente extends Cuenta {
    private int numeroDetransferencias = 0;

    public CuentaCorriente(String tipoCuenta, String numeroDeCuenta, int idUsuario, float saldo) {
        super(tipoCuenta, numeroDeCuenta, idUsuario, saldo);
    }

    @Override
    public void consignarDinero(float dinero) {
        if (dinero > 0) {
            this.saldo += dinero;
            this.numeroDeConsignaciones++;
        }
    }

    @Override
    public void retirarDinero(float dinero){
        if (dinero <= this.saldo && numeroDeRetiros <6) {
            this.saldo -= dinero;
            this.numeroDeRetiros++;
        } else{
            System.out.println("EL máximo de retiros es Cinco");
        }
    }

    @Override
    public ArrayList<Cuenta> transferirDinero(Cuenta cuentaOrigen, Cuenta cuentaDestino,
                                                      float transferencia){
        float dinero = (float) (transferencia + (transferencia * 0.02));

        if (cuentaOrigen.getTipoCuenta() != cuentaDestino.getTipoCuenta()){
            if (transferencia <= this.saldo && this.numeroDetransferencias <2) {
                cuentaOrigen.retirarDinero(dinero);
                cuentaDestino.consignarDinero(transferencia);
                this.numeroDetransferencias++;
            }
        }else {
            if (transferencia <= this.saldo) {
                cuentaOrigen.retirarDinero(transferencia);
                cuentaDestino.consignarDinero(transferencia);
            }
        }
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        cuentas.add(cuentaOrigen);
        cuentas.add(cuentaDestino);
        return cuentas;
    }
}