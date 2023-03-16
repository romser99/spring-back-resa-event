package fr.solutec.re.dao;

import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.Equipe;

import fr.solutec.re.entites.Role;
import fr.solutec.re.enums.RoleEnum;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Repository

public class EquipeDAO {


    private JdbcTemplate jdbcTemplate;

    public EquipeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create (Equipe equipe){
        jdbcTemplate.update(
                "INSERT INTO EQUIPE (PRENOM, NOM, MAIL, TELEPHONE, PASSWORD) VALUES(?,?,?,?,?)",
                equipe.getPrenom(),
                equipe.getNom(),
                equipe.getEmail(),
                equipe.getTelephone(),
                equipe.getPassword()
        );

    }

    public Equipe read(int id) {
        String sql = "SELECT * FROM EQUIPE WHERE id=?";
        Equipe equipe = jdbcTemplate.queryForObject(sql,Equipe.class, new Object[] { id });
        return equipe ;

    }

    public Set<Equipe> search(Map<String, String> params) {
        List<Equipe> equipes = new ArrayList<>();
        String query = "SELECT * FROM EQUIPE";
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
            Equipe equipe = new Equipe();
            equipe.setId((int)item.get("id"));
            equipe.setPrenom((String)item.get("prenom"));
            equipe.setNom((String)item.get("nom"));
            equipe.setEmail((String)item.get("mail"));
            equipe.setTelephone((String)item.get("telephone"));
            equipe.setPassword((String)item.get("password"));
            equipes.add(equipe);
        }
        return Set.copyOf(equipes);
    }

    public void delete(int id){
        jdbcTemplate.update(
                "DELETE FROM EQUIPE WHERE id = ?",
                id);

    }

    public void update(int ideq, RoleEnum libelle){
        jdbcTemplate.update(
                "UPDATE EQUIPE SET ROLE =? WHERE id =?",
                libelle,
                ideq
        );
    }


}
