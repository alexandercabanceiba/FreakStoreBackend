package com.ceiba.articulo.puerto.dao;

import com.ceiba.articulo.modelo.dto.ArticuloDto;

import java.util.List;

public interface DaoArticulo {

    List<ArticuloDto> obtenerArticulos();

    List<ArticuloDto> obtenerArticulosInventariados();
}
