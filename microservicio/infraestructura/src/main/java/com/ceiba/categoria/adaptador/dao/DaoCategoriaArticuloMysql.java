package com.ceiba.categoria.adaptador.dao;

import com.ceiba.categoria.modelo.dto.CategoriaArticuloDTO;
import com.ceiba.categoria.puerto.dao.DaoCategoriaArticulo;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoCategoriaArticuloMysql implements DaoCategoriaArticulo {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoCategoriaArticulo mapeoCategoriaArticulo;

    @SqlStatement(namespace = "categoria", value = "obtenercategorias")
    private static String sqlObtenerCategorias;

    public DaoCategoriaArticuloMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate,MapeoCategoriaArticulo mapeoCategoriaArticulo) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoCategoriaArticulo = mapeoCategoriaArticulo;
    }
    @Override
    public List<CategoriaArticuloDTO> obtenerTodasCategorias() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerCategorias, mapeoCategoriaArticulo);
    }
}
