package com.example.demo.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.livresRepository;

@Service
public class LivresService {
    @Autowired
    private LivresRepository livresRepository;

    public void addLivres(int id_livre, String nom_livre, String auteur_livre){
        livresRepository.addLivres(id_livre, nom_livre, auteur_livre);
    }
    public List<Map<String, Object>> listLivres() {
    return livreRepository.listeLivres();
}
public void deleteLivres(int id_livre) {
    livresRepository.deleteLivres(id_livre);
}
public void updateLivres(int id_livre, String nom_livre, String auteur_livre) {
    livresRepository.updateLivres(id_livre, nom_livre, auteur_livre);
}
public Map<String, Object> getLivresById(int id_livre) {
    return livresRepository.affichage(id_livre);
}
}