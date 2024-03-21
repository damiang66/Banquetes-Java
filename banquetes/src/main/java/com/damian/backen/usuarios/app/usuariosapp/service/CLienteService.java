package com.damian.backen.usuarios.app.usuariosapp.service;

import com.damian.backen.usuarios.app.usuariosapp.endidad.Cliente;

import java.util.List;
import java.util.Optional;

public interface CLienteService {
    public List<Cliente>findAll();
    public Optional<Cliente>findById(Long id);
    public Cliente save(Cliente cliente);
    public void delete(Long id);
    public List<Cliente>finndByNombre(String nombre);
}
