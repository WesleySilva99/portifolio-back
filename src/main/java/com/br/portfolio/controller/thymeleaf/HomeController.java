package com.br.portfolio.controller.thymeleaf;

import com.br.portfolio.util.CaminhosUrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(){

        return CaminhosUrl.CAMINHO_HOME;

    }

    @RequestMapping("/home/profile")
    public String profile(){

        return CaminhosUrl.CAMINHO_PROFILE_HOME;

    }

        @RequestMapping("/home/tables")
        public String tables(){

            return CaminhosUrl.CAMINHO_TABLES_HOME;

        }

    @RequestMapping("/home/icons")
    public String icons(){

        return CaminhosUrl.CAMINHO_ICONS_HOME;

    }

    @RequestMapping("/home/404")
    public String notFound(){

        return CaminhosUrl.CAMINHO_404_HOME;

    }

}
