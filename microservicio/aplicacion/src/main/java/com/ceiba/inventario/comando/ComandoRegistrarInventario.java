package com.ceiba.inventario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoRegistrarInventario {
    private Long idArticulo;
    private int cantidad;
    private String fechaIngreso;
}
