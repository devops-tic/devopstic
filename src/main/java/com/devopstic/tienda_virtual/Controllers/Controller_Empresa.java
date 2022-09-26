package com.devopstic.tienda_virtual.Controllers;


import com.devopstic.tienda_virtual.Model.Empresa;
import com.devopstic.tienda_virtual.Services.Service_Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/enterprises")
public class Controller_Empresa {
    @Autowired
    Service_Empresa empresa;
    @GetMapping
    public List <Empresa> getempresas(){
        return empresa.ListarEmpresas();
    }
    @PostMapping
    public Empresa crearEmpresa (@RequestBody Empresa body){
        return empresa.guardarYActualizarEmpresa(body);
    }
    @GetMapping("/{id}")
    public Optional <Empresa> cosultarEmpresaPorid(@PathVariable Integer id){
        return empresa.cosultarEmpresaPorId(id);
    }
    @PatchMapping("/{id}")
    public Empresa actualizarEmpresa(@RequestBody Empresa body, @PathVariable Integer id){

        Empresa emp= empresa.cosultarEmpresaPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"empresa no encontrada :: "+id+"id no encontrado"));
        emp.setNombre(body.getNombre());
        emp.setDireccion(body.getDireccion());
        emp.setTelefono(body.getTelefono());
        emp.setNit(body.getNit());
        return empresa.guardarYActualizarEmpresa(emp);
    }
    @DeleteMapping("/{id}")
    public String eliminarEmpresa(@PathVariable Integer id){
        empresa.delete(id);
        return "La empresa con el Id : " +id+ " fue eliminada";
    }

}
