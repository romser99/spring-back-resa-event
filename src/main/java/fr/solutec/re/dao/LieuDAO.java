package fr.solutec.re.dao;

import fr.solutec.re.entites.Lieu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LieuDAO {
    private JdbcTemplate jdbcTemplate;

    public LieuDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Lieu lieu) {
        String QUERY = "INSERT INTO LIEU(NOM, ADRESSE_ID) VALUES (?, ?)";
        jdbcTemplate.update(QUERY, lieu.getNom(), lieu.getAdresse().getId());
    }
}


