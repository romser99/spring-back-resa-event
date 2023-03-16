package fr.solutec.re.DAO;

import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Lieu;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    public void create(Lieu lieu) {
        jdbcTemplate.update(
                "INSERT INTO LIEU (nom, id_adresse) VALUES(?, ?)",
                lieu.getNom(),
                lieu.getAdresse().getId()
        );
    }


    public Set<Lieu> read(int id) {
        List<Lieu> lieux = new ArrayList<>();
        String QUERY = "SELECT * FROM LIEU l JOIN ADRESSE a ON l.ID_Adresse=a.ID WHERE l.ID=?";
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY, new Object[]{id});
        for (Map<String, Object> item : items) {
            Lieu lieu = new Lieu();
            Adresse adresse = new Adresse();

            lieu.setId((int) item.get("id"));
            lieu.setNom((String) item.get("nom"));

            adresse.setId((int) item.get("id_adresse"));
            adresse.setNumero((int) item.get("numero"));
            adresse.setRue((String) item.get("rue"));
            adresse.setCodepostal((int) item.get("codepostal"));
            adresse.setVille((String) item.get("ville"));
            adresse.setRegion((String) item.get("region"));
            adresse.setPays((String) item.get("pays"));

            lieu.setAdresse(adresse);
            lieux.add(lieu);
        }
        return Set.copyOf(lieux);
    }


    public void delete(int id) {
        jdbcTemplate.update(
                "DELETE FROM LIEU WHERE id = ?",
                id);

    }

    public Set<Lieu> search(Map<String, String> params) {
        List<Lieu> lieux = new ArrayList<>();    String QUERY = "SELECT * FROM LIEU l JOIN ADRESSE a ON l.ID_Adresse=a.ID";
        if (!params.isEmpty()) {
            List<String> keys = List.copyOf(params.keySet());
            for (int i = 0; i < keys.size(); i++) {
                if (i == 0) {
                    QUERY += " WHERE " + keys.get(i) + " LIKE '%" + params.get(keys.get(i))+"%'";
                }
                else {
                    QUERY += " AND " + keys.get(i) + " LIKE '%" + params.get(keys.get(i))+"%'" ;
                }
            }
        }

        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item : items) {
            Lieu lieu = new Lieu();
            Adresse adresse = new Adresse();
            lieu.setId((int)item.get("id"));
            lieu.setNom((String)item.get("nom"));
            adresse.setId((int)item.get("id_adresse"));
            adresse.setNumero((int)item.get("numero"));
            adresse.setRue((String)item.get("rue"));
            adresse.setCodepostal((int) item.get("codepostal"));
            adresse.setVille((String) item.get("ville"));
            adresse.setRegion((String) item.get("region"));
            adresse.setPays((String) item.get("pays"));
            lieu.setAdresse(adresse);
            lieux.add(lieu);
        }
        return Set.copyOf(lieux);
    }

}



    /*
    public Set<Lieu> readAll() {
        List<Lieu> lieux = new ArrayList<>();
        String QUERY = "SELECT * FROM LIEU l JOIN ADRESSE a ON l.ID_Adresse=a.ID";
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

