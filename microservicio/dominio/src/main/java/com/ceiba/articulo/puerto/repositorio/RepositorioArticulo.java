package com.ceiba.articulo.puerto.repositorio;

import com.ceiba.articulo.modelo.entidad.Articulo;
import com.ceiba.articulo.modelo.entidad.ArticuloInventario;

public interface RepositorioArticulo {
    Long guardar(Articulo articulo);

    ArticuloInventario obtener(Long id);
}
