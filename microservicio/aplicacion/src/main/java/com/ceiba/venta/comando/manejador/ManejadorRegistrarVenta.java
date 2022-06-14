package com.ceiba.venta.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.inventario.servicio.ServicioActualizarInventario;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.venta.comando.ComandoRegistrarVenta;
import com.ceiba.venta.comando.fabrica.FabricaRegistrarVenta;
import com.ceiba.venta.modelo.entidad.RegistrarVenta;
import com.ceiba.venta.servicio.ServicioRegistrarVenta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRegistrarVenta implements ManejadorComandoRespuesta<ComandoRegistrarVenta, ComandoRespuesta<Long>> {

    private final FabricaRegistrarVenta fabricaRegistrarVenta;

    private final ServicioRegistrarVenta servicioRegistrarVenta;

    private final ServicioActualizarInventario servicioActualizarInventario;

    public ManejadorRegistrarVenta(FabricaRegistrarVenta fabricaRegistrarVenta, ServicioRegistrarVenta servicioRegistrarVenta, ServicioActualizarInventario servicioActualizarInventario){
        this.fabricaRegistrarVenta = fabricaRegistrarVenta;
        this.servicioRegistrarVenta = servicioRegistrarVenta;
        this.servicioActualizarInventario = servicioActualizarInventario;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoRegistrarVenta comandoRegistrarVenta) {
        RegistrarVenta registrarVenta = fabricaRegistrarVenta.crear(comandoRegistrarVenta);
        Long respuesta = servicioRegistrarVenta.ejecutar(registrarVenta);
        servicioActualizarInventario.ejecutar(registrarVenta.getInventarioVenta());

        return new ComandoRespuesta<>(respuesta);
    }
}
