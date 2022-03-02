package com.br.portfolio.dao;

import com.br.portfolio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario getByLogin(String login);

}
