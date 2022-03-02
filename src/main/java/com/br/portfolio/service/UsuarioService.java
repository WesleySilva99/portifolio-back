package com.br.portfolio.service;

import com.br.portfolio.dao.UsuarioRepository;
import com.br.portfolio.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioRepository getExperienciaRepository() {
        return usuarioRepository;
    }

    public Usuario getUserByLogin(String login){

        return this.getExperienciaRepository().getByLogin(login);

    }

    public Usuario save(Usuario user){

        return this.getExperienciaRepository().save(user);

    }

}
