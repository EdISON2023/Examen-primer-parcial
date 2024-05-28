package com.example.inventario.edison_productos;

import com.example.inventario.categorias.Categoria;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class EdisonProducto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private double precio;
    private boolean estado; 
    private Date fechaCaducidad;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
