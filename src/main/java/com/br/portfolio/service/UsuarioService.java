package com.br.portfolio.service;

import com.br.portfolio.dao.UsuarioRepository;
import com.br.portfolio.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public Usuario getUserByLogin(String login){

        return this.getUsuarioRepository().getByLogin(login);

    }

    public List<Usuario> findAll(){

        return this.getUsuarioRepository().findAll();

    }

    public Usuario save(Usuario usuario){

        return this.getUsuarioRepository().save(usuario);

    }

}
