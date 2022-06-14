package com.ceiba.categoria.adaptador.repositorio;

import com.ceiba.categoria.modelo.entidad.Categoria;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCategoria implements RowMapper<Categoria>, MapperResult {


    @Override
    public Categoria mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        var id = resultSet.getLong("ID");
        var descripcion = resultSet.getString("DESCRIPCION");

        return Categoria.reconstruir(id, descripcion);
    }
}
