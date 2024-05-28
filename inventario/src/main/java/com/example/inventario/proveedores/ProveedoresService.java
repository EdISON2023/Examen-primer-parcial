package com.example.inventario.proveedores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedoresService {

    @Autowired
    private ProveedoresRepository proveedoresRepository;

    public List<Proveedor> getAllProveedores() {
        return proveedoresRepository.findAll();
    }

    public Optional<Proveedor> getProveedorById(Long id) {
        return proveedoresRepository.findById(id);
    }

    public Proveedor saveProveedor(Proveedor proveedor) {
        return proveedoresRepository.save(proveedor);
    }

    public void deleteProveedor(Long id) {
        proveedoresRepository.deleteById(id);
    }
}
