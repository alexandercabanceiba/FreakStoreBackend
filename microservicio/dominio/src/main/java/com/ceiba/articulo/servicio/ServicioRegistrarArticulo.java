package com.ceiba.articulo.servicio;

import com.ceiba.articulo.modelo.entidad.Articulo;
import com.ceiba.articulo.modelo.entidad.RegistrarArticulo;
import com.ceiba.articulo.puerto.repositorio.RepositorioArticulo;

public class ServicioRegistrarArticulo {

    private final RepositorioArticulo repositorioArticulo;

    public ServicioRegistrarArticulo( RepositorioArticulo repositorioArticulo){
        this.repositorioArticulo = repositorioArticulo;
    }

    public Long ejecutar(RegistrarArticulo registrarArticulo){
        var articulo = Articulo.crear(registrarArticulo);
        return repositorioArticulo.guardar(articulo);
    }

}
