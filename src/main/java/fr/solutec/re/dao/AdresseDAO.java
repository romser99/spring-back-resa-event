package fr.solutec.re.dao;

import fr.solutec.re.entites.Adresse;
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

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@Repository
public class AdresseDAO {
    private JdbcTemplate jdbcTemplate;

    public AdresseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Adresse create (Adresse adresse){
        KeyHolder keyHolder = new GeneratedKeyHolder();


        jdbcTemplate.update( connection -> {
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO ADRESSE (numero, rue, code_postal, ville) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS
                    );
                    ps.setInt(1, adresse.getNumero());
                    ps.setString(2, adresse.getRue());
                    ps.setInt(3, adresse.getCodePostal());
                    ps.setString(4, adresse.getVille());
                    return ps;
                    }, keyHolder);
        int id = keyHolder.getKey().intValue();
        adresse.setId(id);
        return adresse ;

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
        jdbcTemplate.update(
                "DELETE FROM ADRESSE WHERE id = ?",
                id);

    }
}
