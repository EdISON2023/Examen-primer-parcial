package com.example.inventario.edison_productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EdisonProductosRepository extends JpaRepository<EdisonProducto, Long> {

    
    @Query("DELETE FROM EdisonProducto e WHERE e.nombre = ?1")
    void EdisonDeleteProductoNombre(String nombre);
}
