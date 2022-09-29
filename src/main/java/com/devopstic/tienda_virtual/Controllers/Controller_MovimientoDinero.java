package com.devopstic.tienda_virtual.Controllers;

import com.devopstic.tienda_virtual.Model.MovimientoDinero;
import com.devopstic.tienda_virtual.Services.Service_MovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller

public class Controller_MovimientoDinero {
    @Autowired
    Service_MovimientoDinero transaccion;
    @GetMapping("/transacciones")

    public String ListarTransacciones(Model model) {
        transaccion.ListarTransacciones();
        model.addAttribute("mostrarTransaccion", transaccion.ListarTransacciones());
        return "transacciones";

    } @GetMapping("/registroTransacciones")
    public String verFormulario(Model model){
        model.addAttribute("nuevaTransaccion", new MovimientoDinero());
        return "registroTransacciones";

    }
    @PostMapping("/guardarTransaccion")
    public String guardarTransaccion (MovimientoDinero movimientoDinero){
        transaccion.guardarYActualizarTransaccion(movimientoDinero);

        return "redirect:/transacciones";
    }
    @GetMapping("editarTransaccion/{id}")
    public String cosultarTransaccionPorId(@PathVariable int id, Model model ){
        Optional<MovimientoDinero> editeTransaccion=transaccion.consultarTransaccionPorId(id);
        model.addAttribute("editarTransaccion",editeTransaccion);
        return "actualizarTransaccion";
    }
    @DeleteMapping("eliminarTransaccion/{id}")
    public String eliminarTransaccion(Model model, @PathVariable  int id){
        transaccion.delete(id);
        return "redirect:/transacciones";
    }

}
