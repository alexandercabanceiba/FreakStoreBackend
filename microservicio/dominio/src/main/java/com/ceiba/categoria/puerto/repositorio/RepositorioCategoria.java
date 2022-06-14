package com.ceiba.categoria.puerto.repositorio;

import com.ceiba.categoria.modelo.entidad.Categoria;

public interface RepositorioCategoria {

    Categoria obtener(Long id);
}
