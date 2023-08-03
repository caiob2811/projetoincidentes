package com.incidentes.crm.controllers;
import com.incidentes.crm.dao.Incidentedao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.incidentes.crm.entities.Incidente;

import java.util.List;

@Controller
public class IncidenteControllers {
    @Autowired
    private Incidentedao incidenterepositorio;

    @GetMapping("/formincidente")
    public ModelAndView InserirIncidente(Incidente incidente) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("incidente/formincidente");
        mv.addObject("incidente", new Incidente());
        return mv;
    }

    @PostMapping("salvarincidentes")
    public ModelAndView inserirIncidente(@Validated Incidente incidente, BindingResult br) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("incidente/formincidente");
        mv.addObject("incidente");
        mv.setViewName("redirect:/incidentes-adicionados");
        incidenterepositorio.save(incidente);
        return mv;
    }

    @GetMapping("incidentes-adicionados")
    public ModelAndView listagemIncidentes() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Incidente/listIncidente");
        mv.addObject("incidenteList", incidenterepositorio.findAll());
        return mv;
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Incidente/alterar");
        Incidente incidente = incidenterepositorio.getOne(id);
        mv.addObject("incidente", incidente);
        return mv;
    }

    @PostMapping("/alterar")
    public ModelAndView alterar(Incidente incidente) {
        ModelAndView mv = new ModelAndView();
        incidenterepositorio.save(incidente);
        mv.setViewName("redirect:/incidentes-adicionados");
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String excluirIncidente(@PathVariable("id") Integer id) {
        incidenterepositorio.deleteById(id);
        return "redirect:/incidentes-adicionados";
    }

    @GetMapping("filtro-incidente")
    public ModelAndView filtroincidente() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("incidente/filtroincidente");
        return mv;
    }

    @GetMapping("incidentes-ativos")
    public ModelAndView listaIncidentesativos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("incidente/incidentes-ativos");
        mv.addObject("incidentes-ativos", incidenterepositorio.findbyStatusAtivos());
        return mv;
    }

    @GetMapping("incidentes-inativos")
    public ModelAndView listaIncidentesInativos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("incidente/incidentes-inativos");
        mv.addObject("incidentesInativos", incidenterepositorio.findbyStatusInativos());
        return mv;
    }
    @PostMapping("buscar-incidente")
    public ModelAndView buscarIncidente(@RequestParam("nomePesquisa") String name){
        ModelAndView mv = new ModelAndView();
        List<Incidente> incidenteList;
        if (name == null || name.trim().isEmpty()){
            incidenteList = incidenterepositorio.findAll();
        }else {
            incidenteList = incidenterepositorio.findByNameContainingIgnoreCase(name);
        }
        mv.addObject("ListaDeIncidentes", incidenteList);
        mv.setViewName("Incidente/pesquisa");
        return mv;
    }
}