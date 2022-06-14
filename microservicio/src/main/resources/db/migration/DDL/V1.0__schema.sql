create table cliente (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 tipo_cliente varchar(20) not null,
 primary key (id)
);

create table producto (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 aplica_iva TINYINT not null,
 valor DECIMAL(10,2) not null,
 primary key (id)
);

create table factura (
 id int(11) not null auto_increment,
 id_cliente int(11) not null,
 valor_total DECIMAL(10,2) not null,
 estado varchar(20) not null,
 primary key (id)
);

create table producto_facturar (
 id int(11) not null auto_increment,
 id_factura int(11) not null,
 id_producto int(11) not null,
 cantidad int(11) not null,
 primary key (id)
);

ALTER TABLE factura
ADD CONSTRAINT cliente_fk
  FOREIGN KEY (id_cliente)
  REFERENCES cliente (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE producto_facturar
ADD CONSTRAINT producto_fk
  FOREIGN KEY (id_producto)
  REFERENCES producto (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE producto_facturar
ADD CONSTRAINT factura_fk
  FOREIGN KEY (id_factura)
  REFERENCES factura (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

 create table freak_categoria (
    ID int(11) NOT NULL auto_increment,
    DESCRIPCION varchar(50) NOT NULL,
    primary key (ID)
 );

 create table freak_articulo (
    ID int(11) NOT NULL auto_increment,
    DESCRIPCION varchar(50) NOT NULL,
    ID_CATEGORIA int(11) NOT NULL,
    PRECIO decimal(10,0) DEFAULT NULL,
    primary key (ID)
 );

 create table freak_inventario (
    ID int(11) NOT NULL auto_increment,
    ID_ARTICULO int(11) NOT NULL,
    CANTIDAD int(11) DEFAULT NULL,
    FECHA_INGRESO date DEFAULT NULL,
    primary key (ID)
 );

 create table freak_venta (
    ID int(11) NOT NULL auto_increment,
    ID_ARTICULO int(11) NOT NULL,
    PRECIO_VENTA decimal(10,0) DEFAULT NULL,
    CANTIDAD_VENTA int(11) DEFAULT NULL,
    primary key (ID)
 );