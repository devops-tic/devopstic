package com.devopstic.tienda_virtual.Model;

import javax.persistence.*;

@Entity
@Table()

public class Empleado {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)

      private int id;
      private String nombre;
      private String email;
      private String empresa;
      private String rol;

      public Empleado() {
      }

      public Empleado(int id, String nombre, String email, String empresa, String rol) {
            this.id = id;
            this.nombre = nombre;
            this.email = email;
            this.empresa = empresa;
            this.rol = rol;
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
