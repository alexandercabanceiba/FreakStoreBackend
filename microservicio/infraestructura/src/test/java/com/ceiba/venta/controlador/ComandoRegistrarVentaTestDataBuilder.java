package com.ceiba.venta.controlador;

import com.ceiba.venta.comando.ComandoRegistrarVenta;

import java.math.BigDecimal;

public class ComandoRegistrarVentaTestDataBuilder {
    private Long idArticulo;
    private int cantidadVenta;
    private BigDecimal precioVenta;

    public ComandoRegistrarVentaTestDataBuilder crearPorDefecto() {
        this.idArticulo = 2l;
        this.cantidadVenta = 10;
        this.precioVenta = BigDecimal.valueOf(1222);
        return this;
    }

    public ComandoRegistrarVenta build(){
        return new ComandoRegistrarVenta(this.idArticulo, this.cantidadVenta, this.precioVenta);
    }
}


