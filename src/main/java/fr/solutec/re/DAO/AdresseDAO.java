package fr.solutec.re.DAO;

import fr.solutec.re.entites.Adresse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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

    public void create (Adresse adresse) {
        jdbcTemplate.update(
                "INSERT INTO ADRESSE (numero, rue) VALUES(?,?)",
                adresse.getNumero(),
                adresse.getRue()
        );
    }

    public Set<Adresse> readAll() {
        List<Adresse> adresses = new ArrayList<>();
        String QUERY = "select * from ADRESSE";
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item: items){
            Adresse adresse = new Adresse();
            adresse.setId((int)item.get("id"));
            adresse.setNumero((int)item.get("numero"));
            adresse.setRue((String)item.get("rue"));
            adresses.add(adresse);
        }
        return Set.copyOf(adresses);
    }
}
