package com.ceiba.venta.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.venta.comando.ComandoRegistrarVenta;
import com.ceiba.venta.comando.manejador.ManejadorRegistrarVenta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venta")
@Tag(name = "Controlador comando Inventario")
@AllArgsConstructor
public class ComandoControladorVenta {

    private final ManejadorRegistrarVenta manejadorRegistrarVenta;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Registrar Venta", description = "Metodo utilizado para registrar una venta")
    public ComandoRespuesta<Long> registrarVenta(@RequestBody ComandoRegistrarVenta comandoRegistrarVenta){
        return this.manejadorRegistrarVenta.ejecutar(comandoRegistrarVenta);
    }

}
