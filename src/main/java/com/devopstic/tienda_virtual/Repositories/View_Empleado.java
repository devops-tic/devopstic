package com.devopstic.tienda_virtual.Repositories;


import com.devopstic.tienda_virtual.Model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface View_Empleado extends JpaRepository<Empleado,Integer> {
/**
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public Empleado findByEmail(String email);
    **/
}
