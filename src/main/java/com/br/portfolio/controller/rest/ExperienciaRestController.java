package com.br.portfolio.controller.rest;

import com.br.portfolio.model.Experiencia;
import com.br.portfolio.service.ExperienciaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/experiencia/")
public class ExperienciaRestController {

    private ExperienciaService xpService;

    public ExperienciaRestController(ExperienciaService xpService){

        this.xpService = xpService;

    }

    @GetMapping
    public List<Experiencia> buscarExperiencias(){

        return this.xpService.findAll();

    }

    @GetMapping("academicas")
    public List<Experiencia> buscarExperienciasAcademicas(){

        return this.xpService.obterExperienciasAcademicas();

    }

    @GetMapping("profissionais")
    public List<Experiencia> buscarExperienciasProfissionais(){

        return this.xpService.obterExperienciasProfissionai();

    }
}
