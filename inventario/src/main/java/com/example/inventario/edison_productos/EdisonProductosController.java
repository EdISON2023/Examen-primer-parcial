package com.example.inventario.edison_productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/edison/productos")
@Tag(name="controlador de EdisonProductos")
public class EdisonProductosController {

    @Autowired
    private EdisonProductosService productosService;

    @Operation(summary="selecciona todos los EdisonProductos")
    @GetMapping
    public List<EdisonProducto> EdisonGetAllProductos() {
        return productosService.EdisonGetAllProductos();
    }

     @Operation(summary="selecciona por el ID todos los EdisonProductos")
     @GetMapping("/{id}")
     public ResponseEntity<EdisonProducto> EdisonGetProductoById(@PathVariable Long id) {
         return productosService.EdisonGetProductoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary="inserta los EdisonProductos")
    @PostMapping
    public ResponseEntity<EdisonProducto> EdisonSaveProducto(@RequestBody EdisonProducto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productosService.EdisonSaveProducto(producto));
    }

    @Operation(summary="actualiza por el ID los EdisonProductos")
    @PutMapping("/{id}")
    public ResponseEntity<EdisonProducto> EdisonUpdateProducto(@PathVariable Long id, @RequestBody EdisonProducto producto) {
      if (!productosService.EdisonGetProductoById(id).isPresent()) {
             return ResponseEntity.notFound().build();
        }
        producto.setId(id);
         return ResponseEntity.ok(productosService.EdisonSaveProducto(producto));
     }

     @Operation(summary="elimina por el ID los EdisonProductos")
     @DeleteMapping("/{id}")
     public ResponseEntity<Void> EdisonDeleteProducto(@PathVariable Long id) {
        if (!productosService.EdisonGetProductoById(id).isPresent()) {
             return ResponseEntity.notFound().build();
        }
        productosService.EdisonDeleteProducto(id);
        return ResponseEntity.noContent().build();
     }


    @Operation(summary="eliminar por Nombre")
    @DeleteMapping("/nombre/{nombre}")
    public void EdisonDeleteProductoNombre(@PathVariable String nombre){
        productosService.EdisonDeleteProductoNombre(nombre);
    }
}
