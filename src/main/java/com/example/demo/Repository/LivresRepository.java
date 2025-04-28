package com.example.demo.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class LivresRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void addLivres(int id_livre, String nom_livre, String auteur_livre){
        String sql = "INSERT INTO Livres (id_livre, nom_livre, auteur_livre) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, id_livre, nom_livre, auteur_livre);
    }
    public List<Map<String, Object>> listeLivres() {
        String sql = "SELECT * FROM Livres";
        return jdbcTemplate.queryForList(sql);
    }
    public void deleteLivres(int id_livre) {
        String sql = "DELETE FROM Livres WHERE id_livre = ?";
        jdbcTemplate.update(sql, id_livre);
    }
    public void updateLivres(int id_livre, String nom_livre, String auteur_livre) {
        String sql = "UPDATE Livres SET nom_livre = ?, auteur_livre = ? WHERE id_livre = ?";
        jdbcTemplate.update(sql, nom_livre, auteur_livre, id_livre);
    }
    public Map<String, Object> affichage(int id) {
        String sql = "SELECT * FROM Livres WHERE id_livre = ?";
        return jdbcTemplate.queryForMap(sql, id_livre);
    }
}