package com.devopstic.tienda_virtual.Services;


import com.devopstic.tienda_virtual.Model.Empresa;
import com.devopstic.tienda_virtual.Repositories.View_Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Service_Empresa {
    @Autowired
    private View_Empresa empresa;
    public List<Empresa> ListarEmpresas(){
        List<Empresa> empresas=new ArrayList<Empresa>();
        empresas.addAll(empresa.findAll());
        return empresas;
    }
    public Optional<Empresa> cosultarEmpresaPorId(int id) {
        return empresa.findById(id);
    }
    public Empresa guardarYActualizarEmpresa(Empresa empresas) {

        return empresa.save(empresas);
    }
    public void delete(int id) {

        empresa.deleteById(id);
    }

}
