package com.ceiba.articulo.adaptador.repositorio;

import com.ceiba.articulo.adaptador.dao.MapeoArticuloInventario;
import com.ceiba.articulo.modelo.entidad.Articulo;
import com.ceiba.articulo.modelo.entidad.ArticuloInventario;
import com.ceiba.articulo.puerto.repositorio.RepositorioArticulo;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioArticuloMysql implements RepositorioArticulo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoArticuloInventario mapeoArticuloInventario;

    @SqlStatement(namespace = "articulo", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "articulo", value = "obtenerporid")
    private static String sqlObtenerPorId;

    public RepositorioArticuloMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoArticuloInventario mapeoArticuloInventario){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoArticuloInventario = mapeoArticuloInventario;
    }
    @Override
    public Long guardar(Articulo articulo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("ID_CATEGORIA", articulo.getCategoria().getId());
        paramSource.addValue("DESCRIPCION", articulo.getDescripcion());
        paramSource.addValue("PRECIO", articulo.getPrecio());

        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }

    @Override
    public ArticuloInventario obtener(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("ID", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorId, paramSource, mapeoArticuloInventario));
    }
}
