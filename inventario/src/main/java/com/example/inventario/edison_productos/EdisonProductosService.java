package com.example.inventario.edison_productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EdisonProductosService {

    @Autowired
    private EdisonProductosRepository productosRepository;

    public List<EdisonProducto> EdisonGetAllProductos() {
        return productosRepository.findAll();
    }

    public Optional<EdisonProducto> EdisonGetProductoById(Long id) {
        return productosRepository.findById(id);
    }

    public EdisonProducto EdisonSaveProducto(EdisonProducto producto) {
        return productosRepository.save(producto);
    }

    public void EdisonDeleteProducto(Long id) {
        productosRepository.deleteById(id);
    }

    public void EdisonDeleteProductoNombre(String nombre) {
        productosRepository.EdisonDeleteProductoNombre(nombre);
    }
}
