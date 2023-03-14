package fr.solutec.re.DAO;

import fr.solutec.re.entites.Evenement;
import fr.solutec.re.entites.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class TypeDAO {
    private JdbcTemplate jdbcTemplate;

    public TypeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Type type) {
        System.out.println("[DAO]Création d'un nouveau type");
        jdbcTemplate.update(
                "INSERT INTO TYPE (nom) VALUES (?)",
                type.getNom()
        );

    }

    public Set<Type> readAll() {
        System.out.println("[DAO]Lecture des types");
        List<Type> types = new ArrayList<>();
        String QUERY = "SELECT * FROM EVENEMENT";
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item: items) {
            Type type = new Type();
            type.setId((int)item.get("id"));
            type.setNom((String)item.get("nom"));
            types.add(type);
        }
        return Set.copyOf(types);
    }

}
