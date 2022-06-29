package com.ceiba.categoria.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Categoria {

    private Long id;
    private final String descripcion;

    public static Categoria reconstruir(Long id, String descripcion) {
        ValidadorArgumento.validarObligatorio(id, "Id de la categoria es requerido");
        return new Categoria(id, descripcion);
    }
}
