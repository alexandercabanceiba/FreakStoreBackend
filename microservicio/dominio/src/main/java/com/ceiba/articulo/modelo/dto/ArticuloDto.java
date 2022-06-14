package com.ceiba.articulo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@AllArgsConstructor
@Getter
public class ArticuloDto {
    private Long id;
    private Long idCategoria;
    private String descripcion;
    private BigDecimal precio;
}
