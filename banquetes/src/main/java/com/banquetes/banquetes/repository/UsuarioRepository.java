package com.banquetes.banquetes.repository;

import com.banquetes.banquetes.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
