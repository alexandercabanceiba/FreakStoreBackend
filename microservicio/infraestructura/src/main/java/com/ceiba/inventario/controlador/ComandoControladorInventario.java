package com.ceiba.inventario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.inventario.comando.ComandoRegistrarInventario;
import com.ceiba.inventario.comando.manejador.ManejadorRegistrarInventario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventario")
@Tag(name = "Controlador comando Inventario")
public class ComandoControladorInventario {

    private final ManejadorRegistrarInventario manejadorRegistrarInventario;

    public ComandoControladorInventario(ManejadorRegistrarInventario manejadorRegistrarInventario){
        this.manejadorRegistrarInventario = manejadorRegistrarInventario;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Registrar Inventario", description = "Metodo utilizado para registrar el inventario de un articulo")
    public ComandoRespuesta<Long> registrarInventario(@RequestBody ComandoRegistrarInventario comandoRegistrarInventario){
        return this.manejadorRegistrarInventario.ejecutar(comandoRegistrarInventario);
    }
}
