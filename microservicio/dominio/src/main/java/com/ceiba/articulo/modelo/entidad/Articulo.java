package com.ceiba.articulo.modelo.entidad;

import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.dominio.ValidadorArgumento;

import java.math.BigDecimal;

public class Articulo {

    private Long id;
    private Categoria categoria;
    private String descripcion;
    private BigDecimal precio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    private Articulo( Categoria categoria, String descripcion, BigDecimal precio){
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio= precio;
    }

    public static Articulo crear(RegistrarArticulo registrarArticulo) {
        ValidadorArgumento.validarObligatorio(registrarArticulo.getCategoria(), "La categoria es requerida para el articulo");
        ValidadorArgumento.validarObligatorio(registrarArticulo.getDescripcion(), "La descripción es requerida para el articulo");

        return new Articulo(registrarArticulo.getCategoria(),registrarArticulo.getDescripcion(), registrarArticulo.getPrecio());
    }
}
