package com.ceiba.venta.comando.fabrica;

import com.ceiba.inventario.modelo.entidad.InventarioVenta;
import com.ceiba.inventario.puerto.repositorio.RepositorioInventario;
import com.ceiba.venta.comando.ComandoRegistrarVenta;
import com.ceiba.venta.modelo.entidad.RegistrarVenta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FabricaRegistrarVenta {

    private final RepositorioInventario repositorioInventario;

    public RegistrarVenta crear(ComandoRegistrarVenta comandoRegistrarVenta){
        return new RegistrarVenta(obtenerInventarioVenta(comandoRegistrarVenta),
                comandoRegistrarVenta.getIdArticulo(),
                comandoRegistrarVenta.getCantidadVenta(),
                comandoRegistrarVenta.getPrecioVenta()
                );
    }

    private InventarioVenta obtenerInventarioVenta(ComandoRegistrarVenta comandoRegistrarVenta){
        InventarioVenta inventarioVenta = repositorioInventario.obtenerPorIdArticulo(comandoRegistrarVenta.getIdArticulo());
        return new InventarioVenta(inventarioVenta.getId(),
                inventarioVenta.getIdArticulo(),
                inventarioVenta.getCantidad(),
                inventarioVenta.getPrecioArticulo(),
                inventarioVenta.getCantidad() - comandoRegistrarVenta.getCantidadVenta());
    }

}
