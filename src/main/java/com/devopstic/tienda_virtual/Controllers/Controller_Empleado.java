package com.devopstic.tienda_virtual.Controllers;

import com.devopstic.tienda_virtual.Model.Empleado;
import com.devopstic.tienda_virtual.Services.Service_Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Controller
public class Controller_Empleado{
    @Autowired
    Service_Empleado service_empleado;
    @GetMapping("/empleados")
    public String ListarUsuarios(Model model){
        service_empleado.ListarUsuarios();
        model.addAttribute("mostrarEmpleados", service_empleado.ListarUsuarios());
        return "empleados";
    }

    @PostMapping
    public Empleado guardarYActualizaUsuario (@RequestBody Empleado empleado){
        return service_empleado.guardarYActualizaUsuario(empleado);
    }
    @GetMapping("/{id}")
    public Optional<Empleado> cosultarUsuarioPorId(@PathVariable Integer id){
        return service_empleado.cosultarUsuarioPorId(id);
    }
    @PatchMapping("/{id}")
    public Empleado guardarYActualizaUsuario(@RequestBody Empleado body, @PathVariable Integer id){
        Empleado empleado= service_empleado.cosultarUsuarioPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"empleado no encontrado :: "+id+"id no encontrado"));
        empleado.setNombre(body.getNombre());
        empleado.setEmpresa(body.getEmpresa());
        empleado.setRol(body.getRol());
        empleado.setEmail(body.getEmail());
         return service_empleado.guardarYActualizaUsuario(empleado);

    }
    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Integer id){
        service_empleado.delete(id);
        return "El usuario con el Id : " +id+ " fue eliminado";
    }

}
