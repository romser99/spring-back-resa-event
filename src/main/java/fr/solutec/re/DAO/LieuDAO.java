package fr.solutec.re.DAO;

import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Lieu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class LieuDAO {
    private JdbcTemplate jdbcTemplate;
    public LieuDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create (Lieu lieu) {
        jdbcTemplate.update(
                    "INSERT INTO ETABLISSEMENT (nom, id_adresse) VALUES(?, ?)",
                lieu.getNom(),
                lieu.getAdresse().getId()
        );
    }

    public Set<Lieu> search(Map<String, String> params) {
        List<Lieu> lieux = new ArrayList<>();
        String QUERY = "SELECT * FROM ETABLISSEMENT";
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item: items){

            Lieu lieu = new Lieu();
            /*
            Adresse adresse = new Adresse();
            lieu.setId((int)item.get("id"));
            lieu.setNom((String)item.get("nom"));
            adresse.setId((int)item.get("id_adresse"));
            adresse.setNumero((int)item.get("numero"));
            adresse.setRue((String)item.get("rue"));
            lieu.setAdresse(adresse);
            lieux.add(lieu);
            */

        }
        return Set.copyOf(lieux);
    }

    public Lieu read(int id) {
        String QUERY = "SELECT * FROM ETABLISSEMENT WHERE ID=?";
        Lieu lieu = jdbcTemplate.queryForObject(QUERY, Lieu.class, new Object[]  {id});
        return lieu;
    }

    /*
    public Set<Lieu> readAll() {
        List<Lieu> lieux = new ArrayList<>();
        String QUERY = "SELECT * FROM ETABLISSEMENT e JOIN ADRESSE a ON e.ID_Adresse=a.ID";
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item: items){
            Lieu lieu = new Lieu();
            Adresse adresse = new Adresse();

            lieu.setId((int)item.get("id"));
            lieu.setNom((String)item.get("nom"));

            adresse.setId((int)item.get("id_adresse"));
            adresse.setNumero((int)item.get("numero"));
            adresse.setRue((String)item.get("rue"));
            adresse.setRue((String)item.get("code_postal"));
            adresse.setRue((String)item.get("ville"));
            adresse.setRue((String)item.get("region"));
            adresse.setRue((String)item.get("pays"));

            lieu.setAdresse(adresse);
            lieux.add(lieu);
        }
        return Set.copyOf(lieux);
    }
    */
}
