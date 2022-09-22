package com.devopstic.tienda_virtual.Repositories;

import com.devopstic.tienda_virtual.Model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface View_Empresa extends JpaRepository<Empresa,Integer> {
}
