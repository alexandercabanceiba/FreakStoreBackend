package com.ceiba.venta.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;

import java.math.BigDecimal;

public class Venta {

    private Long id;
    private Long idArticulo;
    private int cantidadVenta;
    private BigDecimal precioVenta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(int cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Venta(Long id, Long idArticulo,int cantidadVenta, BigDecimal precioVenta){
        this.id = id;
        this.idArticulo = idArticulo;
        this.cantidadVenta = cantidadVenta;
        this.precioVenta = precioVenta;
    }

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
