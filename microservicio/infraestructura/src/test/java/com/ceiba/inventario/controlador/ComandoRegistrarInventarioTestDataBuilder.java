package com.ceiba.inventario.controlador;

import com.ceiba.inventario.comando.ComandoRegistrarInventario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ComandoRegistrarInventarioTestDataBuilder {
    private Long idArticulo;
    private int cantidad;
    private String fechaIngreso;

    public ComandoRegistrarInventarioTestDataBuilder crearPorDefecto() {

        LocalDate fechaActual = LocalDate.now();
        LocalDate diaAntes = fechaActual.minusDays(1);

        this.idArticulo = 1l;
        this.cantidad = 400;
        this.fechaIngreso = diaAntes.toString();
        return this;
    }

    public ComandoRegistrarInventario build(){
        return new ComandoRegistrarInventario(this.idArticulo, this.cantidad, this.fechaIngreso);
    }
}
