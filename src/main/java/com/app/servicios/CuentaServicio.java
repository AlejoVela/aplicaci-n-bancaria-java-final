package com.app.servicios;

import com.app.entidades.Cuenta;
import com.app.entidades.CuentaCorriente;
import com.app.entidades.CuentaDeAhorros;
import com.app.entidades.Usuario;
import com.app.repositorios.CuentaBaseDeDatos;
import com.app.repositorios.Repositorio;

import java.util.List;
import java.util.Map;

public class CuentaServicio implements Servicio{
    private Repositorio repositorio;

    public CuentaServicio() {
        repositorio = new CuentaBaseDeDatos();
    }

    public Object crear(Map objeto) {
        String numeroCuenta = (String) objeto.get("numeroCuenta");
        int idUsuario = (int) objeto.get("idUsuario");
        String tipoCuenta = (String) objeto.get("TipoCuenta");
        int saldo = (int) objeto.get("saldo");

        if(!tipoCuenta.equalsIgnoreCase("CA") && !tipoCuenta.equalsIgnoreCase("CC")){
            throw new RuntimeException("Los unicos tipos de cuentas adminitdos son CA y CC");
        }

        Cuenta cuenta;
        if(tipoCuenta.equalsIgnoreCase("CC")){
            cuenta = new CuentaCorriente(tipoCuenta, numeroCuenta, idUsuario, saldo);
        } else {
            cuenta = new CuentaDeAhorros(tipoCuenta, numeroCuenta, idUsuario, saldo);
        }

        return repositorio.crear(cuenta);
    }

    @Override
    public String eliminar(Object id) {
        return repositorio.eliminar(id);
    }

    @Override
    public List<?> listar(Object id) {
        return repositorio.listar(id);
    }
}
