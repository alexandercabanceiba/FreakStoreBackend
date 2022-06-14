select fi.ID, fi.ID_ARTICULO, fi.CANTIDAD, fa.PRECIO
from freak_inventario fi
inner join freak_articulo fa ON fa.ID = fi.ID_ARTICULO
where fi.ID_ARTICULO = :ID_ARTICULO