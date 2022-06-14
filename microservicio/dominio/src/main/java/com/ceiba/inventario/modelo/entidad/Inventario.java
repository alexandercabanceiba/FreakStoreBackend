package com.ceiba.inventario.modelo.entidad;

import com.ceiba.articulo.modelo.entidad.ArticuloInventario;
import com.ceiba.dominio.ValidadorArgumento;


public class Inventario {

    private Long id;
    private ArticuloInventario articulo;
    private int cantidad;
    private String fechaIngreso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArticuloInventario getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloInventario articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Inventario(Long id, ArticuloInventario articulo, int cantidad, String fechaIngreso){
        this.id = id;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
    }

    public Inventario(ArticuloInventario articulo, int cantidad, String fechaIngreso){
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
    }

    public Inventario(Long id, int cantidad){
        this.id = id;
        this.cantidad = cantidad;
    }

    public static Inventario crear(RegistrarInventario registrarInventario){
        ValidadorArgumento.validarObligatorio(registrarInventario.getArticulo(), "El articulo es requerido para el inventario");
        ValidadorArgumento.validarQueFechaDadaNoSeaMayorQueFechaActual(registrarInventario.getFechaIngreso(), "La fecha de ingreso no puede ser mayor o igual a la fecha actual");
        ValidadorArgumento.validarMayor(registrarInventario.getCantidad(), 0, "La cantidad no puede ser menor o igual a cero");

        return new Inventario(registrarInventario.getArticulo(), registrarInventario.getCantidad(), registrarInventario.getFechaIngreso());
    }

    public static Inventario actualizar(InventarioVenta inventarioVenta){
        ValidadorArgumento.validarObligatorio(inventarioVenta.getId(), "El id del inventario es requerido para actualizar la cantidad en inventario");
        ValidadorArgumento.validarMayorACero(inventarioVenta.getCantidadDescontada(),  "La cantidad para el inventario no puede ser menor a cero");

        return new Inventario(inventarioVenta.getId(), inventarioVenta.getCantidadDescontada());
    }
}
