package fr.solutec.re.dao;


import fr.solutec.re.entites.Gestionnaire;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class GestionnaireDAO {

    private JdbcTemplate jdbcTemplate;

    public GestionnaireDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create (Gestionnaire gestionnaire){
        jdbcTemplate.update(
                "INSERT INTO GESTIONNAIRE (PRENOM, NOM, MAIL, TELEPHONE, PASSWORD) VALUES(?,?,?,?,?)",
                gestionnaire.getPrenom(),
                gestionnaire.getNom(),
                gestionnaire.getEmail(),
                gestionnaire.getTelephone(),
                gestionnaire.getPassword()
        );

    }

    public Set<Gestionnaire> readALL() {
        List<Gestionnaire> gestionnaires = new ArrayList<>();
        String QUERY = "SELECT * FROM GESTIONNAIRE";
        List<Map<String,Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item: items) {
            Gestionnaire gestionnaire = new Gestionnaire();
            gestionnaire.setId((int)item.get("id"));
            gestionnaire.setPrenom((String)item.get("prenom"));
            gestionnaire.setNom((String)item.get("nom"));
            gestionnaire.setEmail((String)item.get("mail"));
            gestionnaire.setTelephone((String)item.get("telephone"));
            gestionnaire.setPassword((String)item.get("password"));
            gestionnaires.add(gestionnaire);
        }
        return Set.copyOf(gestionnaires);
    }
}
