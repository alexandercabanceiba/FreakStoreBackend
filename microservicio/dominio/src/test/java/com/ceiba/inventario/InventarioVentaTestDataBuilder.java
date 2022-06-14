package com.ceiba.inventario;


import com.ceiba.inventario.modelo.entidad.InventarioVenta;

import java.math.BigDecimal;

public class InventarioVentaTestDataBuilder {

    private Long id;
    private Long idArticulo;
    private int cantidad;
    private BigDecimal precioArticulo;
    private int cantidadDescontada;

    public InventarioVentaTestDataBuilder conInventarioVentaPorDefecto(){
        this.id = 1l;
        this.idArticulo = 1l;
        this.cantidad = 10;
        this.precioArticulo = BigDecimal.valueOf(1222);
        this.cantidadDescontada = 5;
        return this;
    }

    public InventarioVenta build(){
        return new InventarioVenta(id, idArticulo, cantidad, precioArticulo, cantidadDescontada);
    }
}
