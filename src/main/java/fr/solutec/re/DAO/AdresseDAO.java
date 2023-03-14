package fr.solutec.re.DAO;

import fr.solutec.re.entites.Adresse;
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
public class AdresseDAO {
    private JdbcTemplate jdbcTemplate;

    public AdresseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Adresse create(Adresse adresse) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        System.out.println("Creation d'une nouvelle adresse");
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO ADRESSE (numero, rue) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, adresse.getNumero());
            ps.setString(2, adresse.getRue());
            return ps;},keyHolder);
        int id = keyHolder.getKey().intValue();
        adresse.setId(id);
        return adresse;
    }

     public Set<Adresse> readAll() {
        List<Adresse> adresses = new ArrayList<>();
         String QUERY = "SELECT * FROM ADRESSE";
         List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
         for (Map<String, Object> item: items) {
             Adresse adresse = new Adresse();
             adresse.setId((int)item.get("id"));
             adresse.setRue((String)item.get("rue"));
             adresses.add(adresse);
         }
         return Set.copyOf(adresses);
     }


}
