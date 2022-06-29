package com.ceiba.articulo.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.articulo.comando.ComandoRegistrarArticulo;
import com.ceiba.articulo.comando.manejador.ManejadorRegistrarArticulo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articulo")
@Tag(name = "Controlador comando articulo")
@AllArgsConstructor
public class ComandoControladorArticulo {

    private final ManejadorRegistrarArticulo manejadorRegistrarArticulo;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Registrar Articulo", description = "Metodo utilizado para crear un nuevo articulo")
    public ComandoRespuesta<Long> registrarArticulo(@RequestBody ComandoRegistrarArticulo comandoArticuloRegistrar){
        return this.manejadorRegistrarArticulo.ejecutar(comandoArticuloRegistrar);
    }
}
