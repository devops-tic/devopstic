package com.devopstic.tienda_virtual.Controllers;



import com.devopstic.tienda_virtual.Model.Empresa;
import com.devopstic.tienda_virtual.Services.Service_Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class Controller_Empresa {
    @Autowired
    Service_Empresa serviceEmpresa;
    @GetMapping("/empresas")

    public String ListarEmpresas(Model model) {
        serviceEmpresa.ListarEmpresas();
        model.addAttribute("mostrarEmpresas", serviceEmpresa.ListarEmpresas());
        return "empresas";

    } @GetMapping("/registroEmpresas")
    public String verFormulario(Model model){
        model.addAttribute("nuevaEmpresa", new Empresa());
        return "registroEmpresas";

    }
    @PostMapping("/guardar")
    public String guardarEmpresa (Empresa empresa){
        serviceEmpresa.guardarYActualizarEmpresa(empresa);

        return "redirect:/empresas";
    }
    @GetMapping("editarEmpresa/{id}")
    public String cosultarEmpresaPorId(@PathVariable int id, Model model ){
        Optional<Empresa> editEmpresa=serviceEmpresa.cosultarEmpresaPorId(id);
        model.addAttribute("editarEmpresa",editEmpresa);
        return "actualizarEmpresa";
    }
    @GetMapping("borrar/{id}")
    public String eliminarEmpresa(Model model, @PathVariable  int id){
        serviceEmpresa.delete(id);
        return "redirect:/empresas";
    }

}
