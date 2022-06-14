package com.ceiba.articulo.controlador;

import com.ceiba.articulo.consulta.ManejadorConsultarArticulos;
import com.ceiba.articulo.modelo.dto.ArticuloDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articulo")
@Tag(name = "Controlador consulta de los articulos")
public class ConsultaControladorArticulo {

    private final ManejadorConsultarArticulos manejadorConsultarArticulos;

    public ConsultaControladorArticulo(ManejadorConsultarArticulos manejadorConsultarArticulos){
        this.manejadorConsultarArticulos = manejadorConsultarArticulos;
    }

    @GetMapping("obtener-articulos")
    @Operation(summary = "Todas los Articulos", description = "Metodo utilizado para consultar todos ls articulos")
    public List<ArticuloDto> obtenerTodosLosArticulos() {
        return manejadorConsultarArticulos.ejecutar();
    }


}
