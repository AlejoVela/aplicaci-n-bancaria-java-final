package com.app.servicios;

import com.app.entidades.Transaccion;
import com.app.entidades.Usuario;
import com.app.repositorios.CuentaBaseDeDatos;
import com.app.repositorios.Repositorio;
import com.app.repositorios.TransaccionBaseDeDatos;

import java.util.List;
import java.util.Map;

public class TransaccionServicio implements Servicio {
    private Repositorio repositorio;

    public TransaccionServicio() {
        repositorio = new TransaccionBaseDeDatos();
    }

    public Object crear(Map objeto) {

        String tipoTransaccion = (String) objeto.get("tipoTransaccion");
        float monto = (float) objeto.get("monto");
        int idCuenta = (int) objeto.get("idCuenta");
        String tipoCuentaDestino = (String) objeto.get("tipoCuentaDestino");

        Transaccion transaccion = new Transaccion(0, tipoTransaccion, monto, idCuenta, tipoCuentaDestino);
        return repositorio.crear(transaccion);
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
