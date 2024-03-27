package com.damian.backen.usuarios.app.usuariosapp.repositorio;


import com.damian.backen.usuarios.app.usuariosapp.endidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto,Long> {
    public List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
