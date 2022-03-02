package com.br.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableAutoConfiguration
@Entity
@Table(name = "experience")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "desc_principal")
    private String descricaoPrincipal;

    @Column(name = "desc_secundaria")
    private String descricaoSecundaria;

    @Column(name = "desc_func")
    private String descricaoDaFuncao;

    @Column
    private String empresa;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    @Column
    private Long tipoExperiencia;

}
