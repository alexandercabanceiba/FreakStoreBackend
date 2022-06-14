package com.ceiba.articulo.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.articulo.comando.ComandoRegistrarArticulo;
import com.ceiba.articulo.comando.fabrica.FabricaRegistrarArticulo;
import com.ceiba.articulo.servicio.ServicioRegistrarArticulo;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRegistrarArticulo implements ManejadorComandoRespuesta<ComandoRegistrarArticulo, ComandoRespuesta<Long>> {

    private final FabricaRegistrarArticulo fabricaRegistrarArticulo;
    private final ServicioRegistrarArticulo servicioRegistrarArticulo;

    public ManejadorRegistrarArticulo(ServicioRegistrarArticulo servicioRegistrarArticulo, FabricaRegistrarArticulo fabricaRegistrarArticulo){
        this.fabricaRegistrarArticulo = fabricaRegistrarArticulo;
        this.servicioRegistrarArticulo = servicioRegistrarArticulo;
    }
    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoRegistrarArticulo comandoArticuloRegistrar) {
        return new ComandoRespuesta<>(servicioRegistrarArticulo
                .ejecutar(fabricaRegistrarArticulo.crear(comandoArticuloRegistrar)));
    }
}
