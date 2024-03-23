package com.damian.backen.usuarios.app.usuariosapp.controlador;

import com.damian.backen.usuarios.app.usuariosapp.endidad.Categoria;
import com.damian.backen.usuarios.app.usuariosapp.endidad.Producto;
import com.damian.backen.usuarios.app.usuariosapp.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoService productoService;
    private ResponseEntity<?>validar(BindingResult result){
        Map<String,Object> errores = new HashMap<>();
        result.getFieldErrors().forEach(e->{
           errores.put(e.getField(),"El campo " + e.getField() + " " + e.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
    @GetMapping
    public ResponseEntity<?>findAll(){
        return ResponseEntity.ok().body(productoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id){
        Optional<Producto> productoOptional = productoService.findById(id);
        if(productoOptional.isPresent()){
            return ResponseEntity.ok().body(productoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<?>save(@Valid @RequestBody Producto producto,BindingResult result){
        if(result.hasErrors()){
            return validar(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>update (@Valid @RequestBody Producto producto, BindingResult result,@PathVariable Long id ){
        Optional<Producto>productoOptional = productoService.findById(id);
        Producto productoDb = null;
        if(productoOptional.isPresent()){
            productoDb = productoOptional.get();
            productoDb.setCantidad(producto.getCantidad());
            productoDb.setNombre(producto.getNombre());
            productoDb.setCantidad_minima(producto.getCantidad_minima());
            productoDb.setCategoria(producto.getCategoria());
            return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(productoDb))
        }
        return ResponseEntity.notFound().build();
    }
}
