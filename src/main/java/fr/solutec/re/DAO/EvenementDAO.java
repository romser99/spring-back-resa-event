package fr.solutec.re.DAO;

import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Evenement;
import fr.solutec.re.entites.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class EvenementDAO {
    private JdbcTemplate jdbcTemplate;

    public EvenementDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Evenement evenement) {
        System.out.println("[DAO]Création d'un nouvel évènement");
        jdbcTemplate.update(
                "INSERT INTO EVENEMENT (nom, description) VALUES (?, ?)",
                evenement.getNom(),
                evenement.getDescription(),
                evenement.getType()
        );

    }


    public Set<Evenement> readAll() {
        List<Evenement> evenements = new ArrayList<>();
        String QUERY = "SELECT * FROM EVENEMENT e JOIN TYPE t ON e.type_id = t.id";
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item: items) {
            Evenement evenement = new Evenement();
            evenement.setId((int)item.get("id"));
            evenement.setNom((String)item.get("nom"));
            evenement.setDescription((String)item.get("description"));
            evenement.setType((Type)item.get("type"));
            evenements.add(evenement);
        }
        return Set.copyOf(evenements);
    }



}
