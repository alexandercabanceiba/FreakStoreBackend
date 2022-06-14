package com.ceiba.articulo.comando.fabrica;

import com.ceiba.articulo.comando.ComandoRegistrarArticulo;
import com.ceiba.articulo.modelo.entidad.RegistrarArticulo;
import com.ceiba.categoria.puerto.repositorio.RepositorioCategoria;
import org.springframework.stereotype.Component;

@Component
public class FabricaRegistrarArticulo {

    private final RepositorioCategoria repositorioCategoria;

    public FabricaRegistrarArticulo(RepositorioCategoria repositorioCategoria){
        this.repositorioCategoria = repositorioCategoria;
    }

    public RegistrarArticulo crear(ComandoRegistrarArticulo comandoRegistrarArticulo){
        return new RegistrarArticulo(repositorioCategoria.obtener(comandoRegistrarArticulo.getIdCategoria()),
                comandoRegistrarArticulo.getDescripcion(),
                comandoRegistrarArticulo.getPrecio());
    }
}
