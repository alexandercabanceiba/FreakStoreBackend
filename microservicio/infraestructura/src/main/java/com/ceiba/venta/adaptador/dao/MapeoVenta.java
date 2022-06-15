package com.ceiba.venta.adaptador.dao;

import com.ceiba.articulo.modelo.entidad.ArticuloInventario;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.venta.modelo.entidad.Venta;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class MapeoVenta implements RowMapper<Venta>, MapperResult {

    @Override
    public Venta mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("ID");
        var idArticulo = resultSet.getLong("ID_ARTICULO");
        var cantidad = resultSet.getInt("CANTIDAD_VENTA");
        var precioVenta = resultSet.getBigDecimal("PRECIO_VENTA");

        return new Venta(id, idArticulo, cantidad, precioVenta);
    }
}
