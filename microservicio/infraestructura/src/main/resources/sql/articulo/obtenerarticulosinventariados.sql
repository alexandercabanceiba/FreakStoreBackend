select  a.ID, CONCAT( a.DESCRIPCION, ', Disponible:', i.CANTIDAD) AS DESCRIPCION, a.ID_CATEGORIA, a.PRECIO
from freak_articulo a
inner join freak_inventario i ON a.ID = i.ID_ARTICULO