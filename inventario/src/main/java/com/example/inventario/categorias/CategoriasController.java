package com.example.inventario.categorias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@Tag(name="controlador de categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriaService;

    @Operation(summary="selecciona todas las Categorias")
    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    @Operation(summary="selecciona por el id una CATEGORIA")
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @Operation(summary="crea y guarda una nueva CATEGORIA")
    @PostMapping
    public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.saveCategoria(categoria));
    }

    @Operation(summary="actualiza por el id a una CATEGORIA")
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        if (!categoriaService.getCategoriaById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        categoria.setId(id);
        return ResponseEntity.ok(categoriaService.saveCategoria(categoria));
    }

    @Operation(summary="elimina por el id a una CATEGORIA")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        if (!categoriaService.getCategoriaById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
