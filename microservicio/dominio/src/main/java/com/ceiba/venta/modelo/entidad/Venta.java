package com.ceiba.venta.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class Venta {

    private Long id;
    private Long idArticulo;
    private int cantidadVenta;
    private BigDecimal precioVenta;

    public Venta(Long idArticulo,int cantidadVenta, BigDecimal precioVenta){
        this.idArticulo = idArticulo;
        this.cantidadVenta = cantidadVenta;
        this.precioVenta = precioVenta;
    }

    public static Venta crear(RegistrarVenta registrarVenta){
        ValidadorArgumento.validarObligatorio(registrarVenta.getIdArticulo(),"El articulo es requerido para la venta");
        ValidadorArgumento.validarMayorIgual(registrarVenta.getInventarioVenta().getCantidad(), registrarVenta.getCantidadVenta(),"No hay suficiente cantidad en inventario");
        ValidadorArgumento.validarIgual(registrarVenta.getPrecioVenta(), registrarVenta.getInventarioVenta().getPrecioArticulo(), "El precio de venta es diferente al precio del articulo");
        return new Venta(registrarVenta.getIdArticulo(), registrarVenta.getCantidadVenta(), registrarVenta.getPrecioVenta());
    }
}
