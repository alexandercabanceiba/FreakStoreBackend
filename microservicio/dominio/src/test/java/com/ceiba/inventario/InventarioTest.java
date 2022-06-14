package com.ceiba.inventario;

import com.ceiba.BasePrueba;
import com.ceiba.articulo.ArticuloInventarioTestDataBuilder;
import com.ceiba.articulo.modelo.entidad.ArticuloInventario;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.inventario.modelo.entidad.Inventario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

class InventarioTest {

    @Test
    void deberiaCrearElInventarioCorrectamente() {
        ArticuloInventario articuloInventario = new ArticuloInventarioTestDataBuilder()
                .conIdArticulo(2l)
                .conIdCategoria(1l)
                .conDescripcion("PRODUCTO PRUEBA")
                .conPrecio(BigDecimal.valueOf(1222)).build();

        Inventario inventario = new InventarioTestDataBuilder()
                .conArticuloInventario(articuloInventario)
                .conCantidad(3)
                .conFechaIngreso("2022-06-13")
                .crear();

        Assertions.assertEquals(articuloInventario, inventario.getArticulo());
        Assertions.assertEquals(articuloInventario.getId(), inventario.getArticulo().getId());
        Assertions.assertEquals(1l,articuloInventario.getIdCategoria());
        Assertions.assertEquals(1222l, articuloInventario.getPrecio().longValue());
        Assertions.assertEquals(3, inventario.getCantidad());

    }

    @Test
    void inventarioFechaIngresoMayorALaFechaActualDeberiaLanzarError() {
        LocalDate hoy = LocalDate.now();
        LocalDate manana = hoy.plusDays(1);

        BasePrueba.assertThrows(() -> new InventarioTestDataBuilder()
                .conArticuloPorDefecto()
                .conCantidad(3)
                .conFechaIngreso(manana.toString())
                .crear(), ExcepcionValorInvalido.class,
                "La fecha de ingreso no puede ser mayor o igual a la fecha actual");
    }

    @Test
    void inventarioSinArticuloDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new InventarioTestDataBuilder()
                        .conArticuloInventario(null)
                        .conCantidad(3)
                        .conFechaIngreso("2022-06-13")
                        .crear(), ExcepcionValorObligatorio.class,
                "El articulo es requerido para el inventario");
    }

    @Test
    void inventarioConCantidadCeroDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new InventarioTestDataBuilder()
                        .conArticuloPorDefecto()
                        .conCantidad(0)
                        .conFechaIngreso("2022-06-13")
                        .crear(), ExcepcionValorInvalido.class,
                "La cantidad no puede ser menor o igual a cero");
    }
}
