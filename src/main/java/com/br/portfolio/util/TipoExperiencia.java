package com.br.portfolio.util;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum TipoExperiencia {

    ACADEMICA(1L, "Experiencia Acadêmica"),
    PROFISSIONAL(2L, "Experiência Profissional");

    private Long codigo;
    private String descricao;

    TipoExperiencia(Long codigo, String descricao) {

        this.codigo = codigo;
        this.descricao = descricao;


    }

    public static List<TipoExperiencia> getTiposExperiencia() {

        List<TipoExperiencia> retorno = Arrays.asList(TipoExperiencia.values());

        return retorno;

    }

}
