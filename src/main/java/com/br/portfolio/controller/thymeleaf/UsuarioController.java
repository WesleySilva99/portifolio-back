package com.br.portfolio.controller.thymeleaf;

import com.br.portfolio.model.Usuario;
import com.br.portfolio.service.UsuarioService;
import com.br.portfolio.util.CaminhosUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UsuarioController {

    private UsuarioService service;

    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioService service, PasswordEncoder encoder){
        this.service = service;
        this.encoder = encoder;
    }

    @RequestMapping("/usuario/cadastrar")
    public String exibirCadastrarUsuario(){
        return CaminhosUrl.CAMINHO_CADASTRAR_USUARIO;
    }

    @RequestMapping(path = "/usuario/cadastrar/action", method = RequestMethod.POST)
    public String cadastrarUsuario(Usuario usuario, Model model){

        Usuario userCadastrado = this.service.getUserByLogin(usuario.getLogin());
        if (userCadastrado != null){
            model.addAttribute("msg", "Usuário já cadastrado");
            return CaminhosUrl.CAMINHO_CADASTRAR_USUARIO;
        }

        usuario.setSenha(encoder.encode(usuario.getSenha()));

        this.service.save(usuario);

        return CaminhosUrl.CAMINHO_INICIO;
    }

    @RequestMapping("/")
    public String exibirLogin(){
        return CaminhosUrl.CAMINHO_INICIO;
    }

    @RequestMapping(path = "/usuario/logar", method = RequestMethod.POST)
    public String logar(Model model, HttpSession session, Usuario usuario) {

        Usuario userLogado = this.service.getUserByLogin(usuario.getLogin());

        if(userLogado != null && encoder.matches(usuario.getSenha(), userLogado.getSenha())){

            session.setAttribute("usuarioLogado", userLogado);

            return CaminhosUrl.CAMINHO_HOME;

        }else{

            model.addAttribute("msg", "Informações incorretas.");

            return CaminhosUrl.CAMINHO_INICIO;
        }
    }
}