package com.ceiba.inventario.servicio;

import com.ceiba.inventario.modelo.entidad.Inventario;
import com.ceiba.inventario.modelo.entidad.InventarioVenta;
import com.ceiba.inventario.puerto.repositorio.RepositorioInventario;

public class ServicioActualizarInventario {

    private RepositorioInventario repositorioInventario;

    public ServicioActualizarInventario(RepositorioInventario repositorioInventario){
        this.repositorioInventario = repositorioInventario;
    }

    public void ejecutar(InventarioVenta inventarioVenta){
        var inventario = Inventario.actualizar(inventarioVenta);
        repositorioInventario.actualizarCantidadInventario(inventario);
    }
}
