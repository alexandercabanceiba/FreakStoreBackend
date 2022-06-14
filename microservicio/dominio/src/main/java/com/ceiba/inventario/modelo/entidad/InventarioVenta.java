package com.ceiba.inventario.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class InventarioVenta {
    private Long id;
    private Long idArticulo;
    private int cantidad;
    private BigDecimal precioArticulo;
    private int cantidadDescontada;
}
