package com.ceiba.articulo;

import com.ceiba.articulo.modelo.entidad.ArticuloInventario;

import java.math.BigDecimal;

public class ArticuloInventarioTestDataBuilder {
    private Long id;
    private Long idCategoria;
    private String descripcion;
    private BigDecimal precio;

    public ArticuloInventarioTestDataBuilder conArticuloPorDefecto(){
        this.id = 2l;
        this.idCategoria = 1l;
        this.descripcion ="PRODUCTO PRUEBA";
        this.precio = BigDecimal.valueOf(1222);
        return this;
    }

    public ArticuloInventarioTestDataBuilder conIdArticulo(Long id) {
        this.id = id;
        return this;
    }

    public ArticuloInventarioTestDataBuilder conIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
        return this;
    }

    public ArticuloInventarioTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ArticuloInventarioTestDataBuilder conPrecio(BigDecimal precio) {
        this.precio = precio;
        return this;
    }

    public ArticuloInventario build() {
        return new ArticuloInventario(id,idCategoria,descripcion,precio);
    }
}
