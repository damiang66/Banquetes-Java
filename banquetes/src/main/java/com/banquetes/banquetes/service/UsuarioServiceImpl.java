package com.banquetes.banquetes.service;

import com.banquetes.banquetes.entity.Usuario;
import com.banquetes.banquetes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario sava(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Long id) {
            usuarioRepository.deleteById(id);
    }
}
