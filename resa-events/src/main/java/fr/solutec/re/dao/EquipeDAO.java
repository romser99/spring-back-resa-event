package fr.solutec.re.dao;

import fr.solutec.re.entites.Equipe;
import fr.solutec.re.entites.Gestionnaire;
import fr.solutec.re.entites.Role;
import fr.solutec.re.enums.RoleEnum;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public Set<Equipe> readALL() {
        List<Equipe> equipes = new ArrayList<>();
        String QUERY = "SELECT * FROM EQUIPE e JOIN ROLE r ON e role_id = r.id";
        List<Map<String,Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item: items) {
            Equipe equipe = new Equipe();
            Role role = new Role();
            equipe.setId((int)item.get("id"));
            equipe.setPrenom((String)item.get("prenom"));
            equipe.setNom((String)item.get("nom"));
            equipe.setEmail((String)item.get("mail"));
            equipe.setTelephone((String)item.get("telephone"));
            equipe.setPassword((String)item.get("password"));
            role.setId((int)item.get("role_id"));
            role.setLibelle((RoleEnum)item.get("libelle"));
            equipe.setRole(role);
            equipes.add(equipe);
        }
        return Set.copyOf(equipes);
    }
}
