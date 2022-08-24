package com.br.portfolio.dao;

import com.br.portfolio.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {

    List<Experiencia> findByTipoExperiencia(Long tipoExperiencia);

}
