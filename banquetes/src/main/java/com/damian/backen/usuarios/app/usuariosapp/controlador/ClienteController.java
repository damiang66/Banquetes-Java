package com.damian.backen.usuarios.app.usuariosapp.controlador;

import com.damian.backen.usuarios.app.usuariosapp.endidad.Cliente;
import com.damian.backen.usuarios.app.usuariosapp.service.CLienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/clientes")

public class ClienteController {
    @Autowired
    CLienteService cLienteService;
    private ResponseEntity<?>validar (BindingResult result){
        Map<String,Object>errores = new HashMap<>();
      result.getFieldErrors().forEach(e->{
          errores.put(e.getField(),"El campo " + e.getField() + "" + e.getDefaultMessage());
      });
      return ResponseEntity.badRequest().body(errores);
    }
    @GetMapping
    public ResponseEntity<?>findAll(){
        return ResponseEntity.ok().body(cLienteService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
        Optional<Cliente> clienteOptional = cLienteService.findById(id);
        if (clienteOptional.isPresent()){
            return ResponseEntity.ok().body(clienteOptional.get());
        }
        return  ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<?>save (@Valid @RequestBody Cliente cliente, BindingResult result){
        if (result.hasErrors()){
            return validar(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(cLienteService.save(cliente));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>update(@Valid @RequestBody Cliente cliente,BindingResult result,@PathVariable Long id){
        Optional<Cliente>clienteOptional = cLienteService.findById(id);
        Cliente clienteDb = null;
        if (clienteOptional.isPresent()){
            clienteDb = clienteOptional.get();
            clienteDb.setNombre(cliente.getNombre());
            clienteDb.setApellido(cliente.getApellido());
            clienteDb.setTelefono(cliente.getTelefono());
            clienteDb.setEmail(cliente.getEmail());
            clienteDb.setDireccion(cliente.getDireccion());
           // clienteDb.setEmail(cliente.getEmail());
          return   ResponseEntity.status(HttpStatus.CREATED).body(cLienteService.save(clienteDb));
        }
        return ResponseEntity.notFound().build();

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delele(@PathVariable Long id){
        cLienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
