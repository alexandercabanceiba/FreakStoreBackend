package com.ceiba.inventario.modelo.entidad;

import com.ceiba.articulo.modelo.entidad.ArticuloInventario;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegistrarInventario {
    private ArticuloInventario articulo;
    private int cantidad;
    private String fechaIngreso;
}
