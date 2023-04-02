package com.app.repositorios;

import java.util.List;

public interface Repositorio {
    public Object crear(Object objeto);

    public String eliminar(Object objeto);

    public List<?> listar(Object id);
}
