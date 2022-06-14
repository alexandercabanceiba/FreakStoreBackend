package com.ceiba.inventario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.inventario.comando.ComandoRegistrarInventario;
import com.ceiba.inventario.comando.fabrica.FabricaRegistrarInventario;
import com.ceiba.inventario.servicio.ServicioRegistrarInventario;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRegistrarInventario implements ManejadorComandoRespuesta<ComandoRegistrarInventario, ComandoRespuesta<Long>> {

    private final FabricaRegistrarInventario fabricaRegistrarInventario;

    private final ServicioRegistrarInventario servicioRegistrarInventario;

    public ManejadorRegistrarInventario(FabricaRegistrarInventario fabricaRegistrarInventario, ServicioRegistrarInventario servicioRegistrarInventario){
        this.fabricaRegistrarInventario = fabricaRegistrarInventario;
        this.servicioRegistrarInventario = servicioRegistrarInventario;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoRegistrarInventario comandoRegistrarInventario) {
        return new ComandoRespuesta<>(servicioRegistrarInventario.ejecutar(fabricaRegistrarInventario.crear(comandoRegistrarInventario)));
    }
}
