package com.ceiba.articulo.modelo.entidad;

import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@AllArgsConstructor
@Data
public class Articulo {

    private Long id;
    private Categoria categoria;
    private String descripcion;
    private BigDecimal precio;

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
