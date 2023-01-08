package com.platzi.martket.persistence.mapper;

import com.platzi.martket.domain.Purchase;
import com.platzi.martket.domain.PurchaseItem;
import com.platzi.martket.persistence.entities.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "Spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem (ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "idCompra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "compra", ignore = true),
    })
    ComprasProducto toComprarProducto (PurchaseItem item);
}
