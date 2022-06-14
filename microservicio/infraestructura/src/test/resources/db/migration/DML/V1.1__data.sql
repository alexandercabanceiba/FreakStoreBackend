insert into cliente(id, nombre, tipo_cliente) values(1,'Cliente 1','PREFERENCIAL');
insert into cliente(id, nombre, tipo_cliente) values(2,'Cliente 2','COMUN');
insert into producto(id, nombre, aplica_iva, valor) values(1,'Producto 1',1, 25000);
insert into producto(id, nombre, aplica_iva, valor) values(2,'Producto 2',0, 10000);

insert into factura(id_cliente, valor_total, estado ) values(1, 25000, 'ACTIVA');
insert into factura(id_cliente, valor_total, estado ) values(2, 3000, 'ANULADA');
insert into producto_facturar( id_factura, id_producto, cantidad ) values(1, 1, 2);

insert into freak_categoria(ID, DESCRIPCION) values(1, 'COMICS'),(2, 'FIGURAS COLECCIONABLES'),(3, 'ROPA');
insert into freak_articulo (ID, DESCRIPCION, ID_CATEGORIA, PRECIO) values(1, 'PRODUCTO PRUEBA 1', 1, '150000'),(2, 'PRODUCTO PRUEBA 2', 2, '1222'),(3, 'PRODUCTO PRUEBA 3', 3, '5000');
insert into freak_inventario (ID, ID_ARTICULO, CANTIDAD, FECHA_INGRESO) values(1, 2, 10000, '2022-06-12');
insert into freak_venta (ID, ID_ARTICULO, PRECIO_VENTA, CANTIDAD_VENTA) values(1, 1, '150000', 21),(2, 1, '150000', 19);