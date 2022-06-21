select  ID, DESCRIPCION, ID_CATEGORIA, PRECIO
from freak_articulo
where ID not in (select ID_ARTICULO from freak_inventario);