package com.ceiba.venta;

import com.ceiba.articulo.modelo.entidad.ArticuloInventario;
import com.ceiba.inventario.InventarioTestDataBuilder;
import com.ceiba.inventario.InventarioVentaTestDataBuilder;
import com.ceiba.inventario.RegistrarInventarioTestDataBuilder;
import com.ceiba.inventario.modelo.entidad.InventarioVenta;
import com.ceiba.venta.modelo.entidad.RegistrarVenta;

import java.math.BigDecimal;

public class RegistrarVentaTestDataBuilder {
    private InventarioVenta inventarioVenta;
    private Long idArticulo;
    private int cantidadVenta;
    private BigDecimal precioVenta;


    public RegistrarVentaTestDataBuilder conInventarioVenta(InventarioVenta inventarioVenta) {
        this.inventarioVenta = inventarioVenta;
        return this;
    }

    public RegistrarVentaTestDataBuilder conIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
        return this;
    }

    public RegistrarVentaTestDataBuilder conCantidadVenta(int cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
        return this;
    }

    public RegistrarVentaTestDataBuilder conPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
        return this;
    }

    public RegistrarVenta build(){
        return new RegistrarVenta(inventarioVenta,idArticulo,cantidadVenta,precioVenta);
    }
}
