package com.ceiba.articulo.consulta;

import com.ceiba.articulo.modelo.dto.ArticuloDto;
import com.ceiba.articulo.puerto.dao.DaoArticulo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarArticulosInventariados {
    private final DaoArticulo daoArticulo;

    public ManejadorConsultarArticulosInventariados(DaoArticulo daoArticulo){
        this.daoArticulo = daoArticulo;
    }

    public List<ArticuloDto> ejecutar(){
        return daoArticulo.obtenerArticulosInventariados();
    }
}
