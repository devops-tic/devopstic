package com.devopstic.tienda_virtual.Services;


import com.devopstic.tienda_virtual.Model.MovimientoDinero;
import com.devopstic.tienda_virtual.Repositories.View_MovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Service_MovimientoDinero {
    @Autowired
    private View_MovimientoDinero transaccion;
    public List<MovimientoDinero> ListarTransacciones(){
        List<MovimientoDinero> movimientos=new ArrayList<MovimientoDinero>();
        movimientos.addAll(transaccion.findAll());
        return movimientos;
    }
    public Optional<MovimientoDinero> consultarTransaccionPorId(int id) {

        return transaccion.findById(id);
    }
    public MovimientoDinero guardarYActualizarTransaccion(MovimientoDinero movimientoDinero) {
        return transaccion.save(movimientoDinero);
    }
    public void delete(int id) {

        transaccion.deleteById(id);
    }

}
