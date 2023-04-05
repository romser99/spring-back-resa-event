package fr.solutec.resaevent.dao;
import fr.solutec.resaevent.entites.Salle;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class SalleDAO {/*
    private JdbcTemplate jdbcTemplate;

    public SalleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Salle create(Salle salle) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        System.out.println("Creation d'une nouvelle salle");
        this.jdbcTemplate.update((connection) -> {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO SALLE (Nom, Capacite) VALUES(?,?)", 1);
            ps.setString(1, salle.getNom());
            ps.setInt(2, salle.getCapacite());
            return ps;
        }, keyHolder);
        int id = keyHolder.getKey().intValue();
        salle.setId(id);
        return salle;
    }

    public Set<Salle> readAll() {
        List<Salle> salles = new ArrayList();
        String QUERY = "SELECT * FROM SALLE";
        List<Map<String, Object>> items = this.jdbcTemplate.queryForList(QUERY);
        Iterator var4 = items.iterator();

        while(var4.hasNext()) {
            Map<String, Object> item = (Map)var4.next();
            Salle salle = new Salle();
            salle.setId((Integer)item.get("id"));
            salle.setNom((String)item.get("nom"));
            salle.setCapacite((Integer)item.get("capacite"));
            salles.add(salle);
        }

        return Set.copyOf(salles);
    }*/
}
