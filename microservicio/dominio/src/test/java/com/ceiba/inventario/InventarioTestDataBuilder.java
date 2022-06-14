package com.ceiba.inventario;

import com.ceiba.articulo.ArticuloInventarioTestDataBuilder;
import com.ceiba.articulo.modelo.entidad.ArticuloInventario;
import com.ceiba.inventario.modelo.entidad.Inventario;

public class InventarioTestDataBuilder {
    private Long id;
    private ArticuloInventario articulo;
    private int cantidad;
    private String fechaIngreso;
    public InventarioTestDataBuilder conArticuloPorDefecto(){
        this.articulo = new ArticuloInventarioTestDataBuilder().conArticuloPorDefecto().build();
        return this;
    }
    public InventarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public InventarioTestDataBuilder conArticuloInventario(ArticuloInventario articulo) {
        this.articulo = articulo;
        return this;
    }

    public InventarioTestDataBuilder conCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public InventarioTestDataBuilder conFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public Inventario crear(){
        return Inventario.crear(new RegistrarInventarioTestDataBuilder()
                .conArticulo(articulo)
                .conCantidad(cantidad)
                .conFechaIngreso(fechaIngreso)
                .build());
    }

}
