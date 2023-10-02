package com.example.springbootweb.controllers;

import com.example.springbootweb.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/app")
public class IndexController {

    //@RequestMapping(value = "/index", method = RequestMethod.GET)
    @GetMapping({"/index", "/", "/home"})
    public String index(Model model){
        model.addAttribute("titulo", "Hola Spring Frameworkss");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("jose");
        usuario.setApellido("Martinez");
        model.addAttribute("usuario", usuario);
        return "perfil";
    }



}
