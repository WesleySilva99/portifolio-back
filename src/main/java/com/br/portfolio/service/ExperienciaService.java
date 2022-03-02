package com.br.portfolio.service;

import com.br.portfolio.dao.ExperienciaRepository;
import com.br.portfolio.model.Experiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    public ExperienciaRepository getExperienciaRepository() {
        return experienciaRepository;
    }

    public Experiencia save(Experiencia ex){

        return this.getExperienciaRepository().save(ex);

    }

    public List<Experiencia> findAll(){

        return this.getExperienciaRepository().findAll();

    }

}
