package com.ceiba.venta.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoRegistrarVenta {
    private Long idArticulo;
    private int cantidadVenta;
    private BigDecimal precioVenta;
}
