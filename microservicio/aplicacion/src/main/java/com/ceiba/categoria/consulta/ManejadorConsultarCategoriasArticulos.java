package com.ceiba.categoria.consulta;

import com.ceiba.categoria.modelo.dto.CategoriaArticuloDTO;
import com.ceiba.categoria.puerto.dao.DaoCategoriaArticulo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ManejadorConsultarCategoriasArticulos {
    private final DaoCategoriaArticulo daoCategoriaArticulo;

    public List<CategoriaArticuloDTO> ejecutar(){
        return daoCategoriaArticulo.obtenerTodasCategorias();
    }


}
