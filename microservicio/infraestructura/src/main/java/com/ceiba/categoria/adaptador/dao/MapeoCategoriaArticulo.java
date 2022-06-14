package com.ceiba.categoria.adaptador.dao;

import com.ceiba.categoria.modelo.dto.CategoriaArticuloDTO;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoCategoriaArticulo implements RowMapper<CategoriaArticuloDTO>, MapperResult {

    @Override
    public CategoriaArticuloDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("ID");
        var descripcion = resultSet.getString("DESCRIPCION");

        return new CategoriaArticuloDTO(id, descripcion);
    }
}
