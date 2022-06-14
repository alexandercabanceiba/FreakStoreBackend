package com.ceiba.categoria.puerto.dao;

import com.ceiba.categoria.modelo.dto.CategoriaArticuloDTO;

import java.util.List;

public interface DaoCategoriaArticulo {

    List<CategoriaArticuloDTO> obtenerTodasCategorias();
}
