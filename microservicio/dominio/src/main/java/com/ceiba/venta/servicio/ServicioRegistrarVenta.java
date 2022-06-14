package com.ceiba.venta.servicio;

import com.ceiba.venta.modelo.entidad.RegistrarVenta;
import com.ceiba.venta.modelo.entidad.Venta;
import com.ceiba.venta.puerto.repositorio.RepositorioVenta;

public class ServicioRegistrarVenta {

    private RepositorioVenta repositorioVenta;

    public ServicioRegistrarVenta(RepositorioVenta repositorioVenta){
        this.repositorioVenta = repositorioVenta;
    }

    public Long ejecutar(RegistrarVenta registrarVenta){
        var venta = Venta.crear(registrarVenta);
        return repositorioVenta.guardar(venta);
    }
}
