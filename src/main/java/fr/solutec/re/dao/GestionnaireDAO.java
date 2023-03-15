package fr.solutec.re.dao;


import fr.solutec.re.entites.Client;
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
    public Gestionnaire read(int id) {
        String sql = "SELECT * FROM GESTIONNAIRE WHERE id=?";
        Gestionnaire gestionnaire = jdbcTemplate.queryForObject(sql,Gestionnaire.class, new Object[] { id });
        return gestionnaire ;

    }

    public Set<Gestionnaire> search(Map<String, String> params) {
        List<Gestionnaire> gestionnaires = new ArrayList<>();
        String query = "SELECT * FROM GESTIONNAIRE";
        if (!params.isEmpty()) {
            List<String> keys = List.copyOf(params.keySet());
            for (int i = 0; i < keys.size(); i++) {

                if (i == 0) {
                    query += " WHERE " + keys.get(i) + " LIKE '%" + params.get(keys.get(i))+"%'";
                }
                else {
                    query += " AND " + keys.get(i) + " LIKE '%" + params.get(keys.get(i))+"%'" ;
                }
            }
        }
        List<Map<String,Object>> items = jdbcTemplate.queryForList(query);
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

    public void delete(int id){
        jdbcTemplate.update(
                "DELETE FROM GESTIONNAIRE WHERE id = ?",
                id);

    }
}
