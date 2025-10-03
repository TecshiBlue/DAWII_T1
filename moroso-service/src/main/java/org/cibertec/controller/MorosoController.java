package org.cibertec.controller;

import java.util.List;

import org.cibertec.common_service.entity.Moroso;
import org.cibertec.service.MorosoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morosos")
public class MorosoController {

    @Autowired
    private MorosoService morosoService;

    @PostMapping("/generar")
    public String llenarTablaMoroso() {
        morosoService.generarMorososDesdeClientes();
        return " Morosos generados exitosamente";
    }
    
    @GetMapping
    public List<Moroso> getMorosos() {
        return morosoService.getMorosos();
    }

}
