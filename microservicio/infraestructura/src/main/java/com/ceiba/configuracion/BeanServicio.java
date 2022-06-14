package com.ceiba.configuracion;

import com.ceiba.articulo.puerto.repositorio.RepositorioArticulo;
import com.ceiba.articulo.servicio.ServicioRegistrarArticulo;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.factura.servicio.ServicioAnular;
import com.ceiba.factura.servicio.ServicioFacturar;
import com.ceiba.inventario.puerto.repositorio.RepositorioInventario;
import com.ceiba.inventario.servicio.ServicioActualizarInventario;
import com.ceiba.inventario.servicio.ServicioRegistrarInventario;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;
import com.ceiba.venta.servicio.ServicioRegistrarVenta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {


    @Bean
    public ServicioFacturar servicioFacturar(RepositorioFactura repositorioFactura) {
        return new ServicioFacturar(repositorioFactura);
    }

    @Bean
    public ServicioAnular servicioAnular(RepositorioFactura repositorioFactura) {
        return new ServicioAnular(repositorioFactura);
    }

    @Bean
    public ServicioRegistrarArticulo servicioRegistrarArticulo(RepositorioArticulo repositorioArticulo) {
        return new ServicioRegistrarArticulo(repositorioArticulo);
    }

    @Bean
    public ServicioRegistrarInventario servicioRegistrarInventario(RepositorioInventario repositorioInventario) {
        return new ServicioRegistrarInventario(repositorioInventario);
    }

    @Bean
    public ServicioRegistrarVenta servicioRegistrarVenta(RepositorioVenta repositorioVenta) {
        return new ServicioRegistrarVenta(repositorioVenta);
    }

    @Bean
    public ServicioActualizarInventario servicioActualizarInventario(RepositorioInventario repositorioInventario) {
        return new ServicioActualizarInventario(repositorioInventario);
    }

}
