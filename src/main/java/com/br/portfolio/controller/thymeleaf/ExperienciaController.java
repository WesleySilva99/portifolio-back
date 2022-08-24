package com.br.portfolio.controller.thymeleaf;

import com.br.portfolio.model.Experiencia;
import com.br.portfolio.service.ExperienciaService;
import com.br.portfolio.util.CaminhosUrl;
import com.br.portfolio.util.TipoExperiencia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    SimpleDateFormat formatFrontType = new SimpleDateFormat("dd/MM/yyyy");

    public ExperienciaController(ExperienciaService xpService){

        this.experienciaService = xpService;

    }

    @RequestMapping("/experiencia/cadastrar")
    public String cadastrar(Model model){

        model.addAttribute("tiposExperiencia", TipoExperiencia.getTiposExperiencia());
        model.addAttribute("experiencia", new Experiencia());
        model.addAttribute("dataInicioDate", "");
        model.addAttribute("dataFimDate", "");

        return CaminhosUrl.CAMINHO_CADASTRAR_EXPERIENCIA;

    }

    @RequestMapping("/experiencia/listar")
    public String listar(Model model){

        model.addAttribute("experiencias", experienciaService.findAll());

        return CaminhosUrl.CAMINHO_LISTAR_EXPERIENCIA;

    }

    @RequestMapping("/experiencia/editar/{id}")
    public String editar(Model model,
                         @PathVariable("id") Long id){

        Experiencia xp = experienciaService.obterPorId(id);
        String dataInicioString = this.formatFrontType.format(xp.getDataInicio());
        String dataFimString = this.formatFrontType.format(xp.getDataFim());

        model.addAttribute("tiposExperiencia", TipoExperiencia.getTiposExperiencia());
        model.addAttribute("experiencia", xp);
        model.addAttribute("dataInicioDate", dataInicioString);
        model.addAttribute("dataFimDate", dataFimString);

        return CaminhosUrl.CAMINHO_CADASTRAR_EXPERIENCIA;

    }

    @RequestMapping("/experiencia/deletar/{id}")
    public String deletar(Model model,
                         @PathVariable("id") Long id){

        Experiencia xp = experienciaService.obterPorId(id);

        this.experienciaService.deletar(xp);

        model.addAttribute("msg", "Experiencia Removida com sucesso");

        return "forward:" + CaminhosUrl.CAMINHO_FORWARD_LISTAR_EXPERIENCIA;

    }

    @RequestMapping(path = "/experiencia/save", method = RequestMethod.POST)
    public String save(Model model, Experiencia xp,
                            @RequestParam("dataInicioDate") String dataInicio,
                            @RequestParam("dataFimDate") String dataFim) throws ParseException {

        boolean isCadastrar = xp.getId() == null;

        Date dataInicioFormatada = formatDBType.parse(dataInicio);
        Date dataFimFormatada = formatDBType.parse(dataFim);

        xp.setDataInicio(dataInicioFormatada);
        xp.setDataFim(dataFimFormatada);

        this.experienciaService.save(xp);

        if(!isCadastrar){
            model.addAttribute("msg", "Experiencia Alterada com sucesso.");
        }else {
            model.addAttribute("msg", "Experiencia Cadastrada com sucesso.");
        }

        return "forward:" + CaminhosUrl.CAMINHO_FORWARD_LISTAR_EXPERIENCIA;

    }

}
