package com.banquetes.banquetes.controller;

import com.banquetes.banquetes.entity.Usuario;
import com.banquetes.banquetes.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    private ResponseEntity<?>validar(BindingResult result){
        Map<String,Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(e->{
            errores.put(e.getField(), "el campo "+ e.getField()+ "  "+ e.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);

    }
    @GetMapping("")
    public ResponseEntity<?>findAll(){
        return ResponseEntity.ok().body(usuarioService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
        Optional<Usuario>optionalUsuario = usuarioService.findById(id);
        if (optionalUsuario.isPresent()){
            return ResponseEntity.ok().body(optionalUsuario.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<?>save(@Valid @RequestBody Usuario usuario,BindingResult result){
        if(result.hasErrors()){
            return validar(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.sava(usuario));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>update(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){
            return validar(result);
        }
        Optional<Usuario>usuarioOptional = usuarioService.findById(id);
        Usuario usuarioDb = null;
        if (usuarioOptional.isPresent()){
            usuarioDb = usuarioOptional.get();
        usuarioDb.setNombre(usuario.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.sava(usuarioDb));

        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
