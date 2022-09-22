package com.devopstic.tienda_virtual.Repositories;

import com.devopstic.tienda_virtual.Model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface View_Empleado extends JpaRepository<Empleado,Integer> {
}
