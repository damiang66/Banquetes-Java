package com.banquetes.banquetes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @Email
    private String email;
    private String telefono;
    @NotBlank
    private String password;

}
