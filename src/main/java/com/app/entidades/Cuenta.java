package com.app.entidades;

import java.util.ArrayList;

public abstract class Cuenta {

    protected float saldo;
    protected String numeroDeCuenta;
    protected String tipoCuenta;
    protected int numeroDeRetiros = 0;
    protected int numeroDeConsignaciones = 0;
    protected int idUsuario;


    public Cuenta(String tipoCuenta, String numeroDeCuenta, int idUsuario, float saldo) {
        this.tipoCuenta = tipoCuenta;
        this.numeroDeCuenta = numeroDeCuenta;
        this.idUsuario = idUsuario;
        this.saldo = saldo;
    }

    public abstract void consignarDinero(float dinero);

    public  abstract ArrayList<Cuenta> transferirDinero(Cuenta cuentaOrigen, Cuenta cuentaDestino, float transferencia);

    public void retirarDinero (float dinero){
        if (dinero <= this.saldo) {
            this.saldo -= dinero;
            this.numeroDeRetiros++;
        }else {
            System.out.println("Saldo insuficiente");
        }
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getNumeroDeRetiros() {
        return numeroDeRetiros;
    }

    public void setNumeroDeRetiros(int numeroDeRetiros) {
        this.numeroDeRetiros = numeroDeRetiros;
    }

    public int getNumeroDeConsignaciones() {
        return numeroDeConsignaciones;
    }

    public void setNumeroDeConsignaciones(int numeroDeConsignaciones) {
        this.numeroDeConsignaciones = numeroDeConsignaciones;
    }
}
