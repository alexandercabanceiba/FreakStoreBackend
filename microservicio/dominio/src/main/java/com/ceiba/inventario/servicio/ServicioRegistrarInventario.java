package com.ceiba.inventario.servicio;

import com.ceiba.inventario.modelo.entidad.Inventario;
import com.ceiba.inventario.modelo.entidad.RegistrarInventario;
import com.ceiba.inventario.puerto.repositorio.RepositorioInventario;

public class ServicioRegistrarInventario {

    private RepositorioInventario repositorioInventario;
    public ServicioRegistrarInventario(RepositorioInventario repositorioInventario){
        this.repositorioInventario = repositorioInventario;
    }

    public Long ejecutar(RegistrarInventario registrarInventario){
        var inventario = Inventario.crear(registrarInventario);
        return repositorioInventario.guardar(inventario);
    }
}
