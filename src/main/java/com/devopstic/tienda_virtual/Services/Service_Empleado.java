package com.devopstic.tienda_virtual.Services;

import com.devopstic.tienda_virtual.Model.Empleado;
import com.devopstic.tienda_virtual.Repositories.View_Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Service_Empleado {
    @Autowired
    private View_Empleado usuario;
    public List<Empleado> ListarUsuarios(){
        List<Empleado> usuarios= new ArrayList<Empleado>();
        usuarios.addAll(usuario.findAll());
        return usuarios;
    }
    public Optional<Empleado> cosultarUsuarioPorId(int id) {
        return usuario.findById(id);
    }
    public void guardarYActualizaUsuario(Empleado empleado) {
        usuario.save(empleado);
    }
    public void delete(int id) {

        usuario.deleteById(id);
    }


}
