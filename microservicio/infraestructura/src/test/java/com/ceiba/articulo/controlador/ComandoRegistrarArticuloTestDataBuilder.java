package com.ceiba.articulo.controlador;

import com.ceiba.articulo.comando.ComandoRegistrarArticulo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ComandoRegistrarArticuloTestDataBuilder {
    private Long idCategoria;
    private String descripcion;
    private BigDecimal precio;

    public ComandoRegistrarArticuloTestDataBuilder crearPorDefecto() {
        this.idCategoria = 1l;
        this.descripcion = "PRODUCTO PRUEBA 1";
        this.precio = BigDecimal.valueOf(150000);
        return this;
    }

    public ComandoRegistrarArticulo build(){
        return new ComandoRegistrarArticulo(this.idCategoria, this.descripcion, this.precio);
    }
}
