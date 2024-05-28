package com.example.inventario.proveedores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresService proveedoresService;

    @GetMapping
    public List<Proveedor> getAllProveedores() {
        return proveedoresService.getAllProveedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable Long id) {
        return proveedoresService.getProveedorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Proveedor> saveProveedor(@RequestBody Proveedor proveedor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedoresService.saveProveedor(proveedor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> updateProveedor(@PathVariable Long id, @RequestBody Proveedor proveedor) {
        if (!proveedoresService.getProveedorById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        proveedor.setId(id);
        return ResponseEntity.ok(proveedoresService.saveProveedor(proveedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id) {
        if (!proveedoresService.getProveedorById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        proveedoresService.deleteProveedor(id);
        return ResponseEntity.noContent().build();
    }
}
