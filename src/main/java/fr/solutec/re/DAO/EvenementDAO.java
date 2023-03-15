package fr.solutec.re.DAO;

import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Evenement;
import fr.solutec.re.entites.Type;
import org.springframework.data.relational.core.sql.Not;
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

            type.setId((int)item.get("t_id"));
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

    public Set<Evenement> search(Map<String, String> params) {
        List<Evenement> evenements = new ArrayList<>();
        String QUERY = "SELECT * FROM EVENEMENT";
        if (!params.isEmpty()) {
            List<String> keys = List.copyOf(params.keySet());
            for (int i = 0; i < keys.size(); i++) {
                if (i==0) {
                    QUERY += "WHERE" + keys.get(i) + "Like '%" + params.get(keys.get(i)) + "'%";
                }
                else {
                    QUERY += "AND" + keys.get(i) + "Like '%" + params.get(keys.get(i)) + "'%";
                }
            }
        }
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item : items) {
            Evenement evenement = new Evenement();

            evenement.setId((int) item.get("e_id"));
            evenement.setNom((String) item.get("e_nom"));
            evenement.setDescription((String) item.get("description"));
            evenements.add(evenement);
        }
        return Set.copyOf(evenements);
    }


    public void updatenom(String nomevt, int idevt) {
        System.out.println("[DAO] Update d'un nom");
        jdbcTemplate.update("UPDATE EVENEMENT SET nom = ? WHERE id = ?", nomevt, idevt);
    }

    public void updatedescription(String descriptionevt, int idevt) {
        System.out.println("[DAO] Update d'une description");
        jdbcTemplate.update("UPDATE EVENEMENT SET description = ? WHERE id = ?", descriptionevt, idevt);
    }

    public void updatetype(String typeevt, int idevt) {
        System.out.println("[DAO] Update d'un type");
        int idtype = jdbcTemplate.queryForObject("SELECT id FROM TYPE WHERE nom = " + typeevt, null, Integer.class);
        jdbcTemplate.update("UPDATE EVENEMENT SET type_id = ? WHERE id = ?", idtype, idevt);
    }






    public void update(Map<String, String> params) {
        String QUERY = "UPDATE EVENEMENT SET ? = ? WHERE ? = ? ";
        List<String> keys = List.copyOf(params.keySet())
        for (int i = 0; i < keys.size(); i++) {
            if (i==0) {

                jdbcTemplate.update(QUERY, );
    }









    public void deleteparid(int idevt) {
        System.out.println("[DAO] Suppression d'un évènement");
        jdbcTemplate.update("DELETE FROM EVENEMENT WHERE id = ?", idevt);
    }

}
