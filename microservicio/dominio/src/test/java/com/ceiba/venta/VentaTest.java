package com.ceiba.venta;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class VentaTest {

    @Test
    void ventaSinExistenciaEnInventarioDeberiaLanzarError(){
        BasePrueba.assertThrows(() -> new VentaTestDataBuilder()
                .conInventarioVentaPorDefecto()
                .conIdArticulo(1l)
                .conCantidadVenta(15)
                .conPrecioVenta(BigDecimal.valueOf(1222)).crear(), ExcepcionValorInvalido.class,
                "No hay suficiente cantidad en inventario");
    }

    @Test
    void ventaConPrecioDiferenteDelArticuloDeberiaLanzarError(){
        BasePrueba.assertThrows(() -> new VentaTestDataBuilder()
                        .conInventarioVentaPorDefecto()
                        .conIdArticulo(1l)
                        .conCantidadVenta(4)
                        .conPrecioVenta(BigDecimal.valueOf(2000)).crear(), ExcepcionValorInvalido.class,
                "El precio de venta es diferente al precio del articulo");
    }
}
