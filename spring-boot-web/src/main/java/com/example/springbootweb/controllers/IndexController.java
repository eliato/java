package com.example.springbootweb.controllers;

import com.example.springbootweb.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/app")
public class IndexController {

    //@RequestMapping(value = "/index", method = RequestMethod.GET)
    @GetMapping({"/index", "/", "/home"})
    public String index(Model model){
        model.addAttribute("titulo", "Hola Spring Frameworks");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario("jose", "Martinez", "soyeliastorres@gmail.com");
        usuario.setNombre("jose");
        usuario.setApellido("Martinez");
        usuario.setEmail("soyeliastorres@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil de usuario:".concat(usuario.getNombre()));
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){
                //new ArrayList();
                //usuarios.add(new Usuario("jose","Martinez","soyeliastorres@gmail.com"));
                //usuarios.add(new Usuario("Miguel","Martinez2","2soyeliastorres@gmail.com"));
                //usuarios.add(new Usuario("Angel","Martinez3","3soyeliastorres@gmail.com"));

        model.addAttribute("titulo", "Listado Usuario");


        return "listar";

    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuario(){
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("jose","Martinez","soyeliastorres@gmail.com"),
                new Usuario("Miguel","Martinez2","2soyeliastorres@gmail.com"),
                new Usuario("Angel","Martinez3","3soyeliastorres@gmail.com"));
        return usuarios;

    }



}
