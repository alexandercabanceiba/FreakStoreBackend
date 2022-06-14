package com.ceiba.inventario.comando.fabrica;

import com.ceiba.articulo.puerto.repositorio.RepositorioArticulo;
import com.ceiba.inventario.comando.ComandoRegistrarInventario;
import com.ceiba.inventario.modelo.entidad.RegistrarInventario;
import org.springframework.stereotype.Component;

@Component
public class FabricaRegistrarInventario {

    private final RepositorioArticulo repositorioArticulo;

    public FabricaRegistrarInventario(RepositorioArticulo repositorioArticulo){
        this.repositorioArticulo  = repositorioArticulo;
    }

    public RegistrarInventario crear(ComandoRegistrarInventario comandoRegistrarInventario){
        return new RegistrarInventario(repositorioArticulo.obtener(comandoRegistrarInventario.getIdArticulo()),comandoRegistrarInventario.getCantidad(), comandoRegistrarInventario.getFechaIngreso());
    }
}
