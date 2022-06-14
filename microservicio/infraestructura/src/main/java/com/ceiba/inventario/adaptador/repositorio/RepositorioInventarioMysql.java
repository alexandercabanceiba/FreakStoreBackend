package com.ceiba.inventario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.inventario.modelo.entidad.Inventario;
import com.ceiba.inventario.modelo.entidad.InventarioVenta;
import com.ceiba.inventario.puerto.repositorio.RepositorioInventario;
import com.ceiba.inventario.adaptador.dao.MapeoInventarioVenta;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioInventarioMysql implements RepositorioInventario {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoInventarioVenta mapeoInventarioVenta;

    @SqlStatement(namespace = "inventario", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "inventario", value = "obtenerporidarticulo")
    private static String sqlObtenerPorIdArticulo;

    @SqlStatement(namespace = "inventario", value = "actualizarcantidad")
    private static String sqlActualizarCantidad;


    public RepositorioInventarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoInventarioVenta mapeoInventarioVenta){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoInventarioVenta = mapeoInventarioVenta;
    }

    @Override
    public Long guardar(Inventario inventario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("ID_ARTICULO", inventario.getArticulo().getId());
        paramSource.addValue("CANTIDAD", inventario.getCantidad());
        paramSource.addValue("FECHA_INGRESO", inventario.getFechaIngreso());

        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }

    @Override
    public InventarioVenta obtenerPorIdArticulo(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("ID_ARTICULO", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorIdArticulo, paramSource, mapeoInventarioVenta));
    }

    @Override
    public void actualizarCantidadInventario(Inventario inventario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("ID", inventario.getId());
        paramSource.addValue("CANTIDAD", inventario.getCantidad());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizarCantidad, paramSource);

    }
}
