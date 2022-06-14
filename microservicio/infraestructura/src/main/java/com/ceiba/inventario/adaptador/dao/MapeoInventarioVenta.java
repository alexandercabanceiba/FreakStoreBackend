package com.ceiba.inventario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.inventario.modelo.entidad.InventarioVenta;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class MapeoInventarioVenta implements RowMapper<InventarioVenta>, MapperResult {
    @Override
    public InventarioVenta mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("ID");
        var idArticulo = resultSet.getLong("ID_ARTICULO");
        var cantidadInventario = resultSet.getInt("CANTIDAD");
        var precioArticulo = resultSet.getBigDecimal("PRECIO");
        return new InventarioVenta(id,idArticulo,cantidadInventario,precioArticulo, 0);
    }
}
