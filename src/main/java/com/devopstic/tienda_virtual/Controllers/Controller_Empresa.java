package com.devopstic.tienda_virtual.Controllers;

import com.devopstic.tienda_virtual.Interfaces.View_Empresa;
import com.devopstic.tienda_virtual.Model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/enterprises")
public class Controller_Empresa {
    @Autowired
    View_Empresa empresa;
    @GetMapping
    public List <Empresa> getempresas(){
        return empresa.findAll();
    }
    @PostMapping
    public Empresa crearEmpresa (@RequestBody Empresa body){
        return empresa.save(body);
    }
    @GetMapping("/{id}")
    public Optional <Empresa> cosultarEmpresaPorid(@PathVariable Integer id){
        return empresa.findById(id);
    }
    @PatchMapping("/{id}")
    public Empresa actualizarEmpresa(@RequestBody Empresa body, @PathVariable Integer id){

        Empresa emp= empresa.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"empresa no encontrada :: "+id+"id no encontrado"));
        emp.setNombre(body.getNombre());
        emp.setDireccion(body.getDireccion());
        emp.setTelefono(body.getTelefono());
        emp.setNit(body.getNit());
        return empresa.save(emp);
    }
    @DeleteMapping("/{id}")
    public String eliminarEmpresa(@PathVariable Integer id){
        empresa.deleteById(id);
        return "la empresa con el id : " +id+ " fue eliminada";
    }

}
