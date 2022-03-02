package com.br.portfolio.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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

        List<TipoExperiencia> retorno = List.of(TipoExperiencia.values());

        return retorno;

    }

}
