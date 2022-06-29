package com.ceiba.venta.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.venta.adaptador.dao.MapeoVenta;
import com.ceiba.venta.modelo.entidad.Venta;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class RepositorioVentaMysql implements RepositorioVenta {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoVenta mapeoVenta;

    @SqlStatement(namespace = "venta", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "venta", value = "obtenerporid")
    private static String sqlObtenerPorId;

    @Override
    public Long guardar(Venta venta) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("ID_ARTICULO", venta.getIdArticulo());
        paramSource.addValue("PRECIO_VENTA", venta.getPrecioVenta());
        paramSource.addValue("CANTIDAD_VENTA", venta.getCantidadVenta());

        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }

    @Override
    public Venta obtener(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("ID", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorId, paramSource, mapeoVenta));
    }
}
