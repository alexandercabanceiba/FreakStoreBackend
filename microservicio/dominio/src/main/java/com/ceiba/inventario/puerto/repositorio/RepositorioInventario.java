package com.ceiba.inventario.puerto.repositorio;

import com.ceiba.inventario.modelo.entidad.Inventario;
import com.ceiba.inventario.modelo.entidad.InventarioVenta;

public interface RepositorioInventario {
    Long guardar(Inventario inventario);
    InventarioVenta obtenerPorIdArticulo(Long id);
    void actualizarCantidadInventario(Inventario inventario);
}
