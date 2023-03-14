package fr.solutec.re.DAO;

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

@Repository
public class AdresseDAO {
    private JdbcTemplate jdbcTemplate;
    public AdresseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Adresse create (Adresse adresse) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("INSERT INTO ADRESSE (numero,rue,code_postal,ville,region,pays) VALUES(?,?,?,?,?,?)",
                            Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1,adresse.getNumero());
                ps.setString(2,adresse.getRue());
                ps.setInt(3,adresse.getCodepostal());
                ps.setString(4,adresse.getVille());
                ps.setString(5,adresse.getRegion());
                ps.setString(6,adresse.getPays());
                return ps;}, keyHolder);
        int id = keyHolder.getKey().intValue();
        adresse.setId(id);
        return adresse;
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
