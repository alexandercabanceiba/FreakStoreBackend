package com.ceiba.categoria.consulta;

import com.ceiba.categoria.modelo.dto.CategoriaArticuloDTO;
import com.ceiba.categoria.puerto.dao.DaoCategoriaArticulo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorConsultarCategoriasArticulos {
    private final DaoCategoriaArticulo daoCategoriaArticulo;

    public ManejadorConsultarCategoriasArticulos(DaoCategoriaArticulo daoCategoriaArticulo){
        this.daoCategoriaArticulo = daoCategoriaArticulo;
    }

    public List<CategoriaArticuloDTO> ejecutar(){
        return daoCategoriaArticulo.obtenerTodasCategorias();
    }


}
