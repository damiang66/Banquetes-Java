package com.banquetes.banquetes.service;

import com.banquetes.banquetes.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public List<Usuario>findAll();
    public Optional<Usuario>findById(Long id);
    public Usuario sava(Usuario usuario);
    public void delete(Long id);
}
