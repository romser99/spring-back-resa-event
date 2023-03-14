package fr.solutec.re.dao;

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

    public void create (Adresse adresse){
        jdbcTemplate.update(
                "INSERT INTO ADRESSE(numero, rue) VALUES (?,?,?,?)",
                adresse.getNumero(),
                adresse.getRue(),
                adresse.getCodePostal(),
                adresse.getVille()
        );

    }

    public Set<Adresse> readALL() {
        List <Adresse> adresses = new ArrayList<>();
        String QUERY = "SELECT * FROM ADRESSE";
        List<Map<String,Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item: items) {
            Adresse adresse = new Adresse();
            adresse.setId((int)item.get("id"));
            adresse.setNumero((int)item.get("numero"));
            adresse.setRue((String)item.get("rue"));
            adresse.setCodePostal((int)item.get("code_postal"));
            adresse.setVille((String)item.get("ville"));
            adresses.add(adresse);
        }
        return Set.copyOf(adresses);
    }

    public void delete(int id){
        String Strid = Integer.toString(id) ;
        jdbcTemplate.update(
                "DELETE FROM ADRESSE WHERE id = ?",
                Strid);

    }
}
