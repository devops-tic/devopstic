package com.devopstic.tienda_virtual.Controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.devopstic.tienda_virtual.Model.Empleado;
import com.devopstic.tienda_virtual.Repositories.View_Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class Controller_Login {

    @Autowired
    private View_Empleado login;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String userRegistro(Model model) {
        model.addAttribute("user", new Empleado());

        return "formularioDeRegistro";
    }

    @PostMapping("/process_register")
    public String processRegister(Empleado user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        login.save(user);

        return "registroExitoso";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<Empleado> listUsers = login.findAll();
        model.addAttribute("listUsers", listUsers);

        return "usuarios";
    }
}
