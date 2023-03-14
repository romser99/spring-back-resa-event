package fr.solutec.re.DAO;

import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Evenement;
import fr.solutec.re.entites.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EvenementDAO {
    private JdbcTemplate jdbcTemplate;

    public EvenementDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Evenement evenement) {
        // lire le type de la bdd
        String  QUERY_TEMPLATE_ID = "SELECT id FROM TYPE WHERE nom = ?";

         int typeId = (int) jdbcTemplate.queryForObject(
                QUERY_TEMPLATE_ID, new Object[] { evenement.getType().getNom() }, Integer.class);

        System.out.println("[DAO]Création d'un nouvel évènement");
        jdbcTemplate.update(
                "INSERT INTO EVENEMENT (nom, description, date, type_id) VALUES (?, ?, ?, ?)",
                evenement.getNom(),
                evenement.getDescription(),
                evenement.getDate(),
                typeId
        );

    }


    public Set<Evenement> readAll() {
        List<Evenement> evenements = new ArrayList<>();
        String QUERY = "SELECT * FROM EVENEMENT e JOIN TYPE t ON e.type_id = t.id";
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item: items) {
            Evenement evenement = new Evenement();
            Type type = new Type();

            type.setId((int)item.get("id"));
            type.setNom((String)item.get("nom"));

            evenement.setId((int)item.get("id"));
            evenement.setNom((String)item.get("nom"));
            evenement.setDate((Date)item.get("date"));
            evenement.setDescription((String)item.get("description"));
            evenement.setType((Type)item.get("type"));
            evenements.add(evenement);
        }
        return Set.copyOf(evenements);
    }



}
