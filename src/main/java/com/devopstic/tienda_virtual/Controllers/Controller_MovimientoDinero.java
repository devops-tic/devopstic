package com.devopstic.tienda_virtual.Controllers;

import com.devopstic.tienda_virtual.Repositories.View_MovimientoDinero;
import com.devopstic.tienda_virtual.Model.MovimientoDinero;
import com.devopstic.tienda_virtual.Services.Service_MovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/enterprises/movements")
public class Controller_MovimientoDinero {
    @Autowired
    Service_MovimientoDinero transacion;
    @GetMapping
    public List<MovimientoDinero> gettransaccion(){
        return transacion.ListarTransacciones();
    }
    @PostMapping
    public MovimientoDinero crearTrnsaccion (@RequestBody MovimientoDinero body){
        return transacion.guardarYActualizarTransaccion(body);
    }
    @GetMapping("/{id}")
    public Optional<MovimientoDinero> cosultarTransaccionPorid(@PathVariable Integer id){
        return transacion.consultarTransaccionPorId(id);
    }
    @PatchMapping("/{id}")
    public MovimientoDinero actualizarTransaccion(@RequestBody MovimientoDinero body, @PathVariable Integer id){
        MovimientoDinero movimiento= transacion.consultarTransaccionPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"transaccion no encontrada :: "+id+"id no encontrado"));

        movimiento.setConcepto(body.getConcepto());
        movimiento.setMonto(body.getMonto());
        movimiento.setUsuario(body.getUsuario());
        return transacion.guardarYActualizarTransaccion(movimiento);
    }
    @DeleteMapping("/{id}")
    public String eliminarTransaccion(@PathVariable Integer id){
        transacion.delete(id);
        return "la transaccion con el id : " +id+ " fue eliminada";
    }
}
