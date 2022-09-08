package com.devopstic.tienda_virtual.Controllers;

import com.devopstic.tienda_virtual.Interfaces.View_Empleado;
import com.devopstic.tienda_virtual.Model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class Controller_Empleado {
    @Autowired
    View_Empleado usuario;
    @GetMapping
    public List<Empleado> getempleado(){
        return usuario.findAll();
    }
    @PostMapping
    public Empleado crearUsuario (@RequestBody Empleado body){
        return usuario.save(body);
    }
    @GetMapping("/{id}")
    public Optional<Empleado> cosultarUsuarioPorid(@PathVariable Integer id){
        return usuario.findById(id);
    }
    @PatchMapping("/{id}")
    public Empleado actualizarUsuario(@RequestBody Empleado body, @PathVariable Integer id){
        Empleado empleado= usuario.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"empleado no encontrado :: "+id+"id no encontrado"));
        empleado.setNombre(body.getNombre());
        empleado.setEmpresa(body.getEmpresa());
        empleado.setRol(body.getRol());
        empleado.setEmail(body.getEmail());
        return usuario.save(empleado);
    }
    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Integer id){
        usuario.deleteById(id);
        return "el usuario con el id : " +id+ " fue eliminado";
    }


}
