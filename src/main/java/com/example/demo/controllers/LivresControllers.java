package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.livresService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/Livres")
public class LivresControllers {

    @Autowired
    private LivresService  livresService;

    @PostMapping
    public String Addlivres(@RequestParam Integer id_livre, @RequestParam String nom_livre, @RequestParam String auteur_livre) {
        livresService.Addlivres(id_livre, nom_livre, auteur_livre);
        return "Livre ajouté avec succès !";
    }
    @GetMapping    
    public List<Map<String, Object>> listLivres() {
    return livresService.listLivres();
}
@DeleteMapping("/{id_livre}")
public String deleteLivres(@PathVariable("id_livre") int id_livre) {
        livresService.deleteLivres(id_livre);
        return "Livre supprimé avec succès !";
    }
    @PutMapping("/{id_livre}")
    public String updateLivres(@PathVariable("id_livre") int id_livre, 
                                @RequestParam("nom_livre") String nom_livre, 
                                @RequestParam("auteur_livre") String auteur_livre) {
        livresService.updateLivres(id_livre, nom_livre, auteur_livre);
        return "Livres modifié avec succès !";
    }
    @GetMapping("/{id_livre}")
    public Map<String, Object> getLivresById(@PathVariable("id_livre") int id_livre) {
        return livresService.getLivresById(id_livre);
    }
}
