package com.br.portfolio.controller.thymeleaf;

import com.br.portfolio.model.Experiencia;
import com.br.portfolio.service.ExperienciaService;
import com.br.portfolio.util.CaminhosUrl;
import com.br.portfolio.util.TipoExperiencia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ExperienciaController {

    private ExperienciaService experienciaService;

    SimpleDateFormat formatDBType = new SimpleDateFormat("yyyy-MM-dd");

    public ExperienciaController(ExperienciaService xpService){

        this.experienciaService = xpService;

    }

    @RequestMapping("/experiencia/exibirCadastrar")
    public String exibirCadastrar(Model model){

        model.addAttribute("tiposExperiencia", TipoExperiencia.getTiposExperiencia());

        return CaminhosUrl.CAMINHO_CADASTRAR_EXPERIENCIA;

    }

    @RequestMapping(path = "/experiencia/cadastrar", method = RequestMethod.POST)
    public String cadastrar(Experiencia xp,
                            @RequestParam("dataInicioDate") String dataInicio,
                            @RequestParam("dataFimDate") String dataFim) throws ParseException {

        Date dataInicioFormatada = formatDBType.parse(dataInicio);
        Date dataFimFormatada = formatDBType.parse(dataFim);

        xp.setDataInicio(dataInicioFormatada);
        xp.setDataFim(dataFimFormatada);

        this.experienciaService.save(xp);

        return "forward:" + CaminhosUrl.CAMINHO_FORWARD_CADASTRA_EXPERIENCIA;

    }

}
