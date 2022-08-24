package com.br.portfolio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    private String cargo;

    @Column(name = "desc_secundaria")
    private String descricaoSecundaria;

    @Column(name = "desc_func")
    private String descricaoAtividades;

    @Column(name = "nome_empresa")
    private String nomeEmpresa;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    @Column
    private Long tipoExperiencia;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "experencia_skill",
            joinColumns = {@JoinColumn(name = "id_experiencia",
                    referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_skill",
                    referencedColumnName = "id")})
    private List<Skill> skills;

}
