package com.br.portfolio.controller.thymeleaf;

import com.br.portfolio.util.CaminhosUrl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemController {

    @RequestMapping("/")
    public String inicio(){

        return CaminhosUrl.CAMINHO_INICIO;

    }
}
