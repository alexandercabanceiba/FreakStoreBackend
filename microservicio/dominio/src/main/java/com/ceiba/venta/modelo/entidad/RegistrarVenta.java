package com.ceiba.venta.modelo.entidad;

import com.ceiba.inventario.modelo.entidad.InventarioVenta;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@Getter
@AllArgsConstructor
public class RegistrarVenta {
    private InventarioVenta inventarioVenta;
    private Long idArticulo;
    private int cantidadVenta;
    private BigDecimal precioVenta;
}
