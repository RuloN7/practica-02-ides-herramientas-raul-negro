package com.example.init.controller;

import com.example.init.model.RespuestaDTO;
import com.example.init.service.Practica02Service;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Practica02Controller {

    private Practica02Service practica02Service;

    public Practica02Controller(Practica02Service practica02Service) {
        super();
        this.practica02Service = practica02Service;
    }

    @GetMapping(value = "obtenerHerramientas", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RespuestaDTO> obtenerHerramientas(@RequestParam("tecnologia") String tecnologia) {
        return practica02Service.obtenerIDEs(tecnologia);
    }
}
