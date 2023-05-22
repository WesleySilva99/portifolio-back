package com.br.portfolio.controller.rest;

import com.br.portfolio.model.Experiencia;
import com.br.portfolio.service.ExperienciaService;
import com.br.portfolio.util.TipoExperiencia;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/v1/experiencia/")
public class ExperienciaRestController {

    private ExperienciaService xpService;

    public ExperienciaRestController(ExperienciaService xpService){

        this.xpService = xpService;

    }

    @GetMapping("todas")
    public List<Experiencia> buscarExperiencias(){

        List<Experiencia> retorno = this.xpService.findAll();

        return retorno;

    }

    @GetMapping("academicas")
    public List<Experiencia> buscarExperienciasAcademicas(){

        List<Experiencia> retorno = this.xpService.obterExperienciasAcademicas();

        return retorno;

    }

    @GetMapping("profissionais")
    public List<Experiencia> buscarExperienciasProfissionais(){

        List<Experiencia> retorno = this.xpService.obterExperienciasProfissionai();

        return retorno;

    }

    @GetMapping("tipos")
    public List<TipoExperiencia> buscarTiposDeExperiencia(){

        return TipoExperiencia.getTiposExperiencia();

    }
}
