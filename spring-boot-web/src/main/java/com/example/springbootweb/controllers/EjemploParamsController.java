package com.example.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping("/")
    public String index(){
        return "/params/index";
    }
    public String index2(){
        return "/params/index";
    }
    @GetMapping("/string")
    public String param(@RequestParam(name = "texto", required = false, defaultValue = "Algún valor") String texto, Model model){
        model.addAttribute("titulo", "Recibir parametros del Request HTTP GET- URL");
        model.addAttribute("resultado", "El txto enviado es:" + texto);
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String mix(@RequestParam String saludo, @RequestParam Integer numero, Model model){
        model.addAttribute("titulo", "Recibir parametros del Request HTTP GET- URL");
        model.addAttribute("resultado", "El txto en saludo es :" + saludo + "y el numero es: " + numero);
        return "params/ver";
    }
}
