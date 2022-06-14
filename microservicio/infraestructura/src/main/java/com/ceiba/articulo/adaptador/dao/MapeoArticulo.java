package com.ceiba.articulo.adaptador.dao;

import com.ceiba.articulo.modelo.dto.ArticuloDto;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class MapeoArticulo implements RowMapper<ArticuloDto>, MapperResult {

    @Override
    public ArticuloDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("ID");
        var descripcion = resultSet.getString("DESCRIPCION");
        var idCategoria = resultSet.getLong("ID_CATEGORIA");
        var precio = resultSet.getBigDecimal("PRECIO");
        return new ArticuloDto(id, idCategoria, descripcion, precio);
    }
}
