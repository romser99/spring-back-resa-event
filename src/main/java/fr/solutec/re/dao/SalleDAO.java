package fr.solutec.re.dao;

import fr.solutec.re.entites.Salle;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class SalleDAO {

    private JdbcTemplate jdbcTemplate;

    public SalleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Salle create(Salle salle) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        System.out.println("Creation d'une nouvelle salle");
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO SALLE (Nom, Capacite) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, salle.getNom());
            ps.setInt(2, salle.getCapacite());
            return ps;
        }, keyHolder);
        int id = keyHolder.getKey().intValue();
        salle.setId(id);
        return salle;
    }

    public Set<Salle> readAll() {
        List<Salle> salles = new ArrayList<>();
        String QUERY = "SELECT * FROM SALLE";
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item : items) {
            Salle salle = new Salle();
            salle.setId((int) item.get("id"));
            salle.setNom((String) item.get("nom"));
            salle.setCapacite((int) item.get("capacite"));
            salles.add(salle);
        }
        return Set.copyOf(salles);
    }
}