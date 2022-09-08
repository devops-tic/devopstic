package com.devopstic.tienda_virtual.Interfaces;

import com.devopstic.tienda_virtual.Model.Empleado;
import com.devopstic.tienda_virtual.Model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface View_Empleado extends JpaRepository<Empleado,Integer> {
}
