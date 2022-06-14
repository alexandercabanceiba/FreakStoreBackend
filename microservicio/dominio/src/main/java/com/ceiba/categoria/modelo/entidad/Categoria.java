package com.ceiba.categoria.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;

public class Categoria {

    private Long id;
    private final String descripcion;

    private Categoria(Long id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
    }

    public static Categoria reconstruir(Long id, String descripcion) {
        ValidadorArgumento.validarObligatorio(id, "Id de la categoria es requerido");
        return new Categoria(id, descripcion);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
