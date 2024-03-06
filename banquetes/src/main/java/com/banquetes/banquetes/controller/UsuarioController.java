package com.banquetes.banquetes.controller;

import com.banquetes.banquetes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
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
    public ResponseEntity<?>findAll(){
        return ResponseEntity.ok().body(usuarioService.findAll());
    }
}
