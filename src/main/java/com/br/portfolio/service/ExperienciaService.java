package com.br.portfolio.service;

import com.br.portfolio.dao.ExperienciaRepository;
import com.br.portfolio.model.Experiencia;
import com.br.portfolio.util.TipoExperiencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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

    public Experiencia obterPorId(Long id){

        return this.getExperienciaRepository().getById(id);

    }

    public List<Experiencia> obterExperienciasProfissionai(){

        return this.getExperienciaRepository().findByTipoExperiencia(TipoExperiencia.PROFISSIONAL.getCodigo());

    }

    public List<Experiencia> obterExperienciasAcademicas(){

        return this.getExperienciaRepository().findByTipoExperiencia(TipoExperiencia.ACADEMICA.getCodigo());

    }

    public void deletar(Experiencia xp){

        this.getExperienciaRepository().delete(xp);

    }

    public List<Experiencia> trataTiposExperiencia(List<Experiencia> lista){
        for(Experiencia atual: lista){
            atual.setTipoExperienciaEnum(TipoExperiencia.getTipoExperienciaByCodigo(atual.getTipoExperiencia()));
        }
        return lista;
    }

}