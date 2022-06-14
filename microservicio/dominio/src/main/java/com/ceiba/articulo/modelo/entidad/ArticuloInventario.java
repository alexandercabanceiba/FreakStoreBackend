package com.ceiba.articulo.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class ArticuloInventario {

    private Long id;
    private Long idCategoria;
    private String descripcion;
    private BigDecimal precio;
}
