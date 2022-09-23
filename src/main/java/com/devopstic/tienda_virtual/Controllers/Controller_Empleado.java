package com.devopstic.tienda_virtual.Controllers;

import com.devopstic.tienda_virtual.Repositories.View_Empleado;
import com.devopstic.tienda_virtual.Model.Empleado;
import com.devopstic.tienda_virtual.Services.Service_Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class Controller_Empleado {
    @Autowired
    Service_Empleado usuario;
    @GetMapping
    public List<Empleado> getempleado(){
        return usuario.ListarUsuarios();
    }
    @PostMapping
    public void crearUsuario (@RequestBody Empleado empleado){
        usuario.guardarYActualizaUsuario(empleado);
    }
    @GetMapping("/{id}")
    public Optional<Empleado> cosultarUsuarioPorid(@PathVariable Integer id){
        return usuario.cosultarUsuarioPorId(id);
    }
    @PatchMapping("/{id}")
    public Empleado actualizarUsuario(@RequestBody Empleado body, @PathVariable Integer id){
        Empleado empleado= usuario.cosultarUsuarioPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"empleado no encontrado :: "+id+"id no encontrado"));
        empleado.setNombre(body.getNombre());
        empleado.setEmpresa(body.getEmpresa());
        empleado.setRol(body.getRol());
        empleado.setEmail(body.getEmail());
         return usuario.guardarYActualizaUsuario(empleado);

    }
    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Integer id){
        usuario.delete(id);
        return "el usuario con el id : " +id+ " fue eliminado";
    }


}
