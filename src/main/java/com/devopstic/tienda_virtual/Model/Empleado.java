package com.devopstic.tienda_virtual.Model;

import javax.persistence.*;

@Entity
@Table(name = "empleado")

public class Empleado {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)

      private int id;
      private String nombre;
      private String email;
      private String password;
      private String empresa;
      private String rol;

      public Empleado() {

      }

      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public String getNombre() {
            return nombre;
      }

      public void setNombre(String nombre) {
            this.nombre = nombre;
      }

      public String getEmail() {
            return email;
      }

      public void setEmail(String email) {
            this.email = email;
      }

      public String getPassword() {
            return password;
      }

      public void setPassword(String password) {
            this.password = password;
      }

      public String getEmpresa() {
            return empresa;
      }

      public void setEmpresa(String empresa) {
            this.empresa = empresa;
      }

      public String getRol() {
            return rol;
      }

      public void setRol(String rol) {
            this.rol = rol;
      }
}
