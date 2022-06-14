package com.ceiba.inventario;

import com.ceiba.articulo.modelo.entidad.ArticuloInventario;
import com.ceiba.inventario.modelo.entidad.RegistrarInventario;

public class RegistrarInventarioTestDataBuilder {

    private ArticuloInventario articulo;
    private int cantidad;
    private String fechaIngreso;

    public RegistrarInventarioTestDataBuilder conArticulo(ArticuloInventario articulo) {
        this.articulo = articulo;
        return this;
    }

    public RegistrarInventarioTestDataBuilder conCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public RegistrarInventarioTestDataBuilder conFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public RegistrarInventario build(){
        return new RegistrarInventario(articulo,cantidad,fechaIngreso);
    }
}
