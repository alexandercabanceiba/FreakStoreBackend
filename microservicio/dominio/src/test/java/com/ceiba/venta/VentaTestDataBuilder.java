package com.ceiba.venta;

import com.ceiba.inventario.InventarioVentaTestDataBuilder;
import com.ceiba.inventario.RegistrarInventarioTestDataBuilder;
import com.ceiba.inventario.modelo.entidad.Inventario;
import com.ceiba.inventario.modelo.entidad.InventarioVenta;
import com.ceiba.venta.modelo.entidad.Venta;

import java.math.BigDecimal;

public class VentaTestDataBuilder {

    private Long id;
    private Long idArticulo;
    private int cantidadVenta;
    private BigDecimal precioVenta;
    private InventarioVenta inventarioVenta;

    public VentaTestDataBuilder conInventarioVentaPorDefecto() {
        this.inventarioVenta = new InventarioVentaTestDataBuilder().conInventarioVentaPorDefecto().build();
        return this;
    }

    public VentaTestDataBuilder conIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
        return this;
    }

    public VentaTestDataBuilder conCantidadVenta(int cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
        return this;
    }

    public VentaTestDataBuilder conPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
        return this;
    }

    public Venta crear(){
        return Venta.crear(new RegistrarVentaTestDataBuilder()
                .conInventarioVenta(inventarioVenta)
                .conIdArticulo(idArticulo)
                .conCantidadVenta(cantidadVenta)
                .conPrecioVenta(precioVenta)
                .build());
    }
}
