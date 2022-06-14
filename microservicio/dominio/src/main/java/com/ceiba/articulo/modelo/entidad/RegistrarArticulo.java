package com.ceiba.articulo.modelo.entidad;

import com.ceiba.categoria.modelo.entidad.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@Getter
@AllArgsConstructor
public class RegistrarArticulo {
    private Categoria categoria;
    private String descripcion;
    private BigDecimal precio;
}
