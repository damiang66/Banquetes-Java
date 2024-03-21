package com.damian.backen.usuarios.app.usuariosapp.service;

import com.damian.backen.usuarios.app.usuariosapp.endidad.Cliente;
import com.damian.backen.usuarios.app.usuariosapp.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImp implements CLienteService{
    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> finndByNombre(String nombre) {
       return clienteRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
