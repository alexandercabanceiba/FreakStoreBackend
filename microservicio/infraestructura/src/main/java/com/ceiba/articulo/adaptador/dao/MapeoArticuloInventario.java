package com.ceiba.articulo.adaptador.dao;

import com.ceiba.articulo.modelo.entidad.ArticuloInventario;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoArticuloInventario implements RowMapper<ArticuloInventario>, MapperResult{

    @Override
    public ArticuloInventario mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("ID");
        var descripcion = resultSet.getString("DESCRIPCION");
        var idCategoria = resultSet.getLong("ID_CATEGORIA");
        var precio = resultSet.getBigDecimal("PRECIO");
        return new ArticuloInventario(id, idCategoria, descripcion, precio);
    }
}
