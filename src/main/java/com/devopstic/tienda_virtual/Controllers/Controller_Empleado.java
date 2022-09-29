package com.devopstic.tienda_virtual.Controllers;

import com.devopstic.tienda_virtual.Model.Empleado;
import com.devopstic.tienda_virtual.Services.Service_Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/registroEmpleados")
    public String verFormulario(Model model){
        model.addAttribute("nuevoEmpleado", new Empleado());
        return "registroEmpleados";

    }
    @PostMapping("/save")
    public String guardarUsuario (Empleado empleado){
        service_empleado.guardarYActualizaUsuario(empleado);

        return "redirect:/empleados";
    }

    @GetMapping("editar/{id}")
    public String cosultarUsuarioPorId(@PathVariable int id, Model model ){
        Optional<Empleado> editEmpleado=service_empleado.cosultarUsuarioPorId(id);
        model.addAttribute("editarEmpleado",editEmpleado);
        return "actualizarEmpleado";
    }

    @GetMapping ("eliminar/{id}")
    public String eliminarUsuario(Model model,@PathVariable int id){
        service_empleado.delete(id);

        return "redirect:/empleados";
    }


}
