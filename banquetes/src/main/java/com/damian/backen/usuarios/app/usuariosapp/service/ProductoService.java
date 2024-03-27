package com.damian.backen.usuarios.app.usuariosapp.service;

import com.damian.backen.usuarios.app.usuariosapp.endidad.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    public List<Producto> findAll();
    public Optional<Producto>findById(Long id);
    public Producto save(Producto producto);
    public void deleteById(Long id);
    public List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
