package org.example.api.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.api.repositories.TerceiroRepository;
import org.example.api.services.TerceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TerceiroController {

    @Autowired
    private TerceiroService terceiroService;

    @GetMapping("/teste")
    public Object getTeste() {
        return terceiroService.listarTerceiros();
    }
}