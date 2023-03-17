package fr.solutec.resaevent.a_evenement_type.dao;

import fr.solutec.re.entites.Type;
import fr.solutec.resaevent.a_evenement_type.entites.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
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

    public Type create(Type type) {
        System.out.println("[DAO] Création d'un type");
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO TYPE ()", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, type.getNom());
            return ps;}, keyHolder);
        int id = (int) keyHolder.getKey();
        type.setId(id);
        return type;
        }

    public Set<Type> readAll() {
        System.out.println("[DAO] Lecture des types");
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

    public void delete(String nomtype){
        System.out.println("[DAO] Suppression d'un type");
        jdbcTemplate.update("DELETE FROM TYPE WHERE nom = ?", nomtype);
    }

}
