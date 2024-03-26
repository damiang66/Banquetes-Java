package com.damian.backen.usuarios.app.usuariosapp.endidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    @ManyToOne
    private Categoria categoria;
    private Integer cantidad;
    private Integer cantidad_minima;
    private Integer cantidadEnAlquiler;

}
