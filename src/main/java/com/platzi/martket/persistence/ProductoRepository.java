package com.platzi.martket.persistence;

import com.platzi.martket.persistence.crud.ProductoCrudRepository;
import com.platzi.martket.persistence.entities.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    ProductoCrudRepository productoCrudRepository;
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }
    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
}
