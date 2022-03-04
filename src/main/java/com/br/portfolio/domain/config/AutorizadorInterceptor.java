package com.br.portfolio.domain.config;

import com.br.portfolio.model.Usuario;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutorizadorInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object controller) throws
            Exception {


        String uri = request.getRequestURI();


        if (uri.contains("bootstrap") || uri.contains("css") || uri.contains("scss") ||
                uri.contains("img") || uri.contains("js") || uri.contains("icon")
                || uri.endsWith("logar")
                || uri.endsWith("/") || uri.contains("/api/v1/")
                || uri.contains("/usuario/cadastrar")) {

            return true;
        }


        Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");

        if(usuarioLogado != null){
            return true;
        }

        if (usuarioLogado == null && uri.contains("home")) {

            response.sendRedirect("/");
            return false;

        }

        response.sendRedirect("/");
        return false;

    }

}
