package com.ceiba.categoria.controlador;

import com.ceiba.categoria.consulta.ManejadorConsultarCategoriasArticulos;
import com.ceiba.categoria.modelo.dto.CategoriaArticuloDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@Tag(name = "Controlador consulta de las categorias de los articulos")
@AllArgsConstructor
public class ConsultaControladorCategoriasArticulos {
    private final ManejadorConsultarCategoriasArticulos manejadorConsultarCategoriasArticulos;

    @GetMapping("obtener-todas-categorias")
    @Operation(summary = "Todas las Categorias", description = "Metodo utilizado para consultar todas las categorias")
    public List<CategoriaArticuloDTO> obtenerTodasLasCategorias() {
        return manejadorConsultarCategoriasArticulos.ejecutar();
    }


}
