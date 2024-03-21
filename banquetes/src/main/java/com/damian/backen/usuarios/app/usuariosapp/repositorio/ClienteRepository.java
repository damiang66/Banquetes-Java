package com.damian.backen.usuarios.app.usuariosapp.repositorio;

import com.damian.backen.usuarios.app.usuariosapp.endidad.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    public List<Cliente>findByNombreContainingIgnoreCase(String mombre);
}
