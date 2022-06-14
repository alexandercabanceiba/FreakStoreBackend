package com.ceiba.articulo.adaptador.dao;

import com.ceiba.articulo.modelo.dto.ArticuloDto;
import com.ceiba.articulo.puerto.dao.DaoArticulo;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoArticuloMysql implements DaoArticulo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoArticulo mapeoArticulo;

    @SqlStatement(namespace = "articulo", value = "obtenerarticulos")
    private static String sqlObtenerArticulos;

    public DaoArticuloMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoArticulo mapeoArticulo){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoArticulo = mapeoArticulo;
    }
    @Override
    public List<ArticuloDto> obtenerArticulos() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerArticulos, mapeoArticulo);
    }
}
