package com.br.portfolio.domain.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutorizadorInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object controller) throws
            Exception {

        boolean retorno = true;

        String uri = request.getRequestURI();
        /*

        if (uri.contains("bootstrap") || uri.contains("css") ||
                uri.contains("img") || uri.contains("js")
                || uri.endsWith("exibir-login")
                || uri.endsWith("deslogar")
                || uri.endsWith("import-menu")
                || uri.endsWith("imports")
                || uri.endsWith("import-imoveis-list")
                || uri.endsWith("efetuar-login")
                || uri.contains("imovel-detalhe/")
                || uri.endsWith("/")) {

            retorno = true;
        }


        Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");

        if (usuarioLogado == null && uri.contains("-adm")) {

            response.sendRedirect("/");
            return false;

        }

        if (usuarioLogado != null
                && usuarioLogado.getTipoUsuario().getId() != 1
                && uri.contains("-adm")) {

            response.sendRedirect("/");
            return false;

        }

        if (usuarioLogado != null
                && usuarioLogado.getTipoUsuario().getId() == 1
                && uri.contains("-adm")) {

            return true;

        }

        if (usuarioLogado != null
                && uri.endsWith("deslogar")) {
            return true;
        }

        response.sendRedirect("/");
        return false;

        */

        return retorno;

    }

}
