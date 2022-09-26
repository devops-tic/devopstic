package com.devopstic.tienda_virtual.Repositories;


import com.devopstic.tienda_virtual.Model.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface View_MovimientoDinero extends JpaRepository<MovimientoDinero,Integer> {

}
