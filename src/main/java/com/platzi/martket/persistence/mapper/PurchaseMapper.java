package com.platzi.martket.persistence.mapper;

import com.platzi.martket.domain.Purchase;
import com.platzi.martket.persistence.entities.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "Spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "idCompra" ,target ="purchaseId" ),
            @Mapping(source = "idCliente",target = "clientId" ),
            @Mapping(source = "medioPago",target = "paymentMethod" ),
            @Mapping(source = "fecha",target = "date" ),
            @Mapping(source = "comentario",target = "comment" ),
            @Mapping(source = "estado",target = "state" ),
            @Mapping(source = "productos",target = "item" )

    })
    Purchase toPurchase (Compra compra);
    List<Purchase> toPurchases(List<Compra> compras);
    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra (Purchase purchase);
}
