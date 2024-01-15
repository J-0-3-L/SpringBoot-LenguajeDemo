package com.joel.lenguaje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joel.lenguaje.models.Idioma;
import com.joel.lenguaje.repositories.IdiomaRepository;

@Controller
@RequestMapping("/languages")
public class IdiomasController {

    @Autowired
    private IdiomaRepository idiomaRepository;
    
    //mostrar
    @GetMapping()
    public String index(Model model , @ModelAttribute("language") Idioma idioma){
        model.addAttribute("languages", idiomaRepository.findAll());
        return "index";
    }

    //ver por id
    @GetMapping("/{id}")
    public String viewLanguage(@PathVariable Long id, Model model) {
        Idioma idioma = idiomaRepository.findById(id).orElse(null);
        if (idioma == null) {
            return "error";
        }
        model.addAttribute("language", idioma);
        return "view";
    }

    //crear
    @PostMapping("")
    public String createLanguage(@ModelAttribute("language") Idioma idioma) {
        idiomaRepository.save(idioma);
        return "redirect:/languages";
    }

    //editar
    @GetMapping("/editar/{id}")
    public String editLanguage(@PathVariable Long id, Model model) {
        Idioma idioma = idiomaRepository.findById(id).orElse(null);
        if(idioma!=null){
            model.addAttribute("language", idioma);
            model.addAttribute("accion","/languages/editar/"+ id);
            return "edit";
        }
        return "redirect:/languages";
    }
    @PostMapping("/editar/{id}")
    public String updateLanguage(@PathVariable Long id, @ModelAttribute Idioma idiomActualizado) {
        Idioma idiomaExistente= idiomaRepository.findById(id).orElse(null);
        if(idiomaExistente!=null){
            idiomaExistente.setName(idiomActualizado.getName());
            idiomaExistente.setCreator(idiomActualizado.getCreator());
            idiomaExistente.setCurrentVersion(idiomActualizado.getCurrentVersion());
            idiomaRepository.save(idiomaExistente);
        }
        return "redirect:/languages";
    }

    //eliminar
    @GetMapping("/eliminar/{id}")
    public String deletLenguage(@PathVariable Long id){
        idiomaRepository.deleteById(id);
        return "redirect:/languages";
    }
}
