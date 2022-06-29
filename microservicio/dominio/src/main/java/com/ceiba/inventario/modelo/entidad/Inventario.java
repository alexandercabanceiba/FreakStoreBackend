package com.ceiba.inventario.modelo.entidad;

import com.ceiba.articulo.modelo.entidad.ArticuloInventario;
import com.ceiba.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Inventario {

    private Long id;
    private ArticuloInventario articulo;
    private int cantidad;
    private String fechaIngreso;

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
