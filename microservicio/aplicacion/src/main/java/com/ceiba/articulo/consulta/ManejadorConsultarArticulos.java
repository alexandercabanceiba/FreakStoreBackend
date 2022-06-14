package com.ceiba.articulo.consulta;

import com.ceiba.articulo.modelo.dto.ArticuloDto;
import com.ceiba.articulo.puerto.dao.DaoArticulo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarArticulos {
    private final DaoArticulo daoArticulo;

    public ManejadorConsultarArticulos(DaoArticulo daoArticulo){
        this.daoArticulo = daoArticulo;
    }

    public List<ArticuloDto> ejecutar(){
        return daoArticulo.obtenerArticulos();
    }
}
