package com.damian.backen.usuarios.app.usuariosapp.service;

import com.damian.backen.usuarios.app.usuariosapp.endidad.Producto;
import com.damian.backen.usuarios.app.usuariosapp.repositorio.CategoriaRepository;
import com.damian.backen.usuarios.app.usuariosapp.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImp implements ProductoService {
    @Autowired
    ProductoRepositorio productoRepositorio;
    @Autowired
    CategoriaRepository categoriaRepository;
    @Override
    public List<Producto> findAll() {
        return productoRepositorio.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepositorio.findById(id);
    }

    @Override
    public Producto save(Producto producto) {

        return productoRepositorio.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoRepositorio.deleteById(id);

    }
}
