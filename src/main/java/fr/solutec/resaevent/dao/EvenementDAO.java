package fr.solutec.resaevent.dao;
import fr.solutec.resaevent.entites.Evenement;
import fr.solutec.resaevent.entites.Salle;
import fr.solutec.resaevent.entites.Type;
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
        System.out.println("[DAO] Création d'un nouvel évènement");
        // lire le type de la bdd
        String QUERY_TEMPLATE_ID_TYPE = "SELECT id FROM TYPE WHERE nom = ?";

        int typeId = (int) jdbcTemplate.queryForObject(
                QUERY_TEMPLATE_ID_TYPE, new Object[]{evenement.getType().getNom()}, Integer.class);

        System.out.println("[DAO]Création d'un nouvel évènement");
        jdbcTemplate.update(
                "INSERT INTO EVENEMENT (nom, description, type_id) VALUES (?, ?, ?)",
                evenement.getNom(),
                evenement.getDescription(),
                typeId
        );
    }


    public Set<Evenement> readAll() {
        System.out.println("[DAO] Lecture de tous les évènements");
        List<Evenement> evenements = new ArrayList<>();
        String QUERY = "SELECT  e.id AS e_id, t.id AS t_id, e.nom AS e_nom, t.nom AS t_nom, description, type_id FROM EVENEMENT e JOIN TYPE t ON e.type_id = t.id";
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item : items) {
            Evenement evenement = new Evenement();
            Type type = new Type();

            type.setId((int) item.get("t_id"));
            type.setNom((String) item.get("t_nom"));

            evenement.setId((int) item.get("e_id"));
            evenement.setNom((String) item.get("e_nom"));
            evenement.setDescription((String) item.get("description"));
            evenement.setType(type);
            evenements.add(evenement);
        }
        return Set.copyOf(evenements);
    }


    public Set<Evenement> readparnom(String nomevt) {
        System.out.println("[DAO] Lecture d'évènements par nom");
        List<Evenement> evenements = new ArrayList<>();
        String QUERY = "SELECT  e.id AS e_id, t.id AS t_id, e.nom AS e_nom, t.nom AS t_nom, description, type_id FROM EVENEMENT e JOIN TYPE t ON e.type_id = t.id WHERE e.nom = ?";
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY, nomevt);
        for (Map<String, Object> item : items) {
            Evenement evenement = new Evenement();
            Type type = new Type();

            type.setId((int) item.get("t_id"));
            type.setNom((String) item.get("t_nom"));

            evenement.setId((int) item.get("e_id"));
            evenement.setNom((String) item.get("e_nom"));
            evenement.setDescription((String) item.get("description"));
            evenement.setType(type);
            evenements.add(evenement);
        }

        return Set.copyOf(evenements);
    }

    public Set<Evenement> readparid(int idevt) {
        System.out.println("[DAO] Lecture d'évènements par id");
        List<Evenement> evenements = new ArrayList<>();
        String QUERY = "SELECT * FROM EVENEMENT e JOIN TYPE t ON e.type_id = t.id WHERE e.id = ?";
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY, idevt);
        for (Map<String, Object> item : items) {
            Evenement evenement = new Evenement();
            Type type = new Type();

            type.setId((int) item.get("t.id"));
            type.setNom((String) item.get("t.nom"));

            evenement.setId((int) item.get("e.id"));
            evenement.setNom((String) item.get("e.nom"));
            evenement.setDescription((String) item.get("e.description"));
            evenement.setType((Type) item.get("e.type"));
            evenements.add(evenement);
        }

        return Set.copyOf(evenements);
    }

    public Set<Evenement> readpartype(String typeevt) {
        System.out.println("[DAO] Lecture d'évènements par type");
        if (typeevt != null) {
            int idtype = jdbcTemplate.queryForObject("SELECT id FROM TYPE WHERE nom = " + typeevt, null, Integer.class);

            List<Evenement> evenements = new ArrayList<>();
            String QUERY = "SELECT * FROM EVENEMENT e JOIN TYPE t ON e.type_id = t.id WHERE t.id = ?" + idtype;
            List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
            for (Map<String, Object> item : items) {
                Evenement evenement = new Evenement();
                Type type = new Type();

                type.setId((int) item.get("t.id"));
                type.setNom((String) item.get("t.nom"));

                evenement.setId((int) item.get("e.id"));
                evenement.setNom((String) item.get("e.nom"));
                evenement.setDescription((String) item.get("e.description"));
                evenement.setType((Type) item.get("e.type"));
                evenements.add(evenement);
            }
            return Set.copyOf(evenements);
        } else {
            System.out.println("Veuillez renseigner le nom du type recherché");
            return null;
        }
    }

    public List<Evenement> search(Map<String, Object> params) {
        List<Evenement> evenements = new ArrayList<>();
        String QUERY =
                "SELECT e.id AS e_id, e.nom AS e_nom," +
                        "t.id AS t_id, t.nom AS t_nom," +
                        "e.description AS e_description," +
                        "s.id AS s_id, s.nom as s_nom " +
                        "FROM EVENEMENT e " +
                        "JOIN TYPE t " +
                        "ON id_type = t.id " +
                        "JOIN SALLE s " +
                        "ON id_salle = s.id ";
        if (!params.isEmpty()) {
            List<String> keys = List.copyOf(params.keySet()); // join date
            for (int i = 0; i < keys.size(); i++) {
                if (i == 0) {
                    QUERY += " WHERE " + keys.get(i) + " Like '%" + params.get(keys.get(i)) + "%'";
                } else {
                    QUERY += " AND " + keys.get(i) + " Like '%" + params.get(keys.get(i)) + "%'";
                }
            }
        }
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item : items) {
            Evenement evenement = new Evenement();
            Type type = new Type();
            Salle salle = new Salle();

            evenement.setId((int) item.get("e_id"));
            evenement.setNom((String) item.get("e_nom"));
            evenement.setDescription((String)item.get("e_description"));
            type.setId((int)item.get("t_id"));
            type.setNom((String)item.get("t_nom"));
            salle.setId((int)item.get("s_id"));
            type.setNom((String)item.get("s_nom"));
            evenement.setType(type);

            evenements.add(evenement);
        }
        return List.copyOf(evenements);
    }

    public void deleteparid(int idevt) {
        System.out.println("[DAO] Suppression d'un évènement");
        jdbcTemplate.update("DELETE FROM EVENEMENT WHERE id = ?", idevt);
    }

}

