package com.devopstic.tienda_virtual.Interfaces;

import com.devopstic.tienda_virtual.Model.Empresa;
import com.devopstic.tienda_virtual.Model.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface View_MovimientoDinero extends JpaRepository<MovimientoDinero,Integer> {
}
