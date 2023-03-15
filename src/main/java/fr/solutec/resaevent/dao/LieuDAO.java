package fr.solutec.resaevent.dao;

import fr.solutec.resaevent.entites.Adresse;
import fr.solutec.resaevent.entites.Agenda;
import fr.solutec.resaevent.entites.Lieu;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
                "INSERT INTO LIEU(NOM, ADRESSE_ID) VALUES (?, ?)",
                lieu.getNom(),
                lieu.getAdresse().getId());
    }

    public Lieu update(Lieu lieu) {

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE LIEU SET NOM=? WHERE ID=?;");
            ps.setString(1, lieu.getNom());
            ps.setInt(2, lieu.getId());

            return ps;
        });
        return lieu;
    }
public Lieu read(int id){
        String sql = "SELECT * FROM LIEU WHERE ID=?";
        Lieu lieu = jdbcTemplate.queryForObject(sql, Lieu.class, new Object[] { id });
        return lieu;
    }

    public Set<Lieu> search(Map<String, String> params) {
        List<Lieu> lieux = new ArrayList<>();

            String QUERY = "SELECT * FROM LIEU l JOIN ADRESSE a ON l.ADRESSE_ID=a.ID;";

            List<Map<String,Object>> items = jdbcTemplate.queryForList(QUERY);

            //EXECUTION DE LA REQUETE
            for (Map<String, Object> item: items) {
                Lieu lieu = new Lieu();
                Adresse adresse = new Adresse();
                lieu.setId((int) item.get("id"));
                lieu.setNom((String) item.get("nom"));
                adresse.setNumero((int) item.get("numero"));
                adresse.setRue((String) item.get("rue"));
                adresse.setCodePostal((int) item.get("code_postal"));
                adresse.setVille((String) item.get("ville"));
                adresse.setRegion((String) item.get("region"));
                adresse.setPays((String) item.get("pays"));
                lieu.setAdresse(adresse);
                lieux.add(lieu);
            }
        return Set.copyOf(lieux);
    }
}

/*ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Adresse adresse = new Adresse();
                adresse.setId(resultSet.getInt(1));
                adresse.setNumero(resultSet.getInt(2));
                adresse.setRue(resultSet.getString(3));
                adresse.setCodePostal(resultSet.getInt(4));
                adresse.setVille(resultSet.getString(5));
                adresse.setRegion(resultSet.getString(6));

                Lieu lieu = new Lieu();
                lieu.setNom(resultSet.getString(1));
                lieu.setIdAdresse(resultSet.getInt(2));
                //lieu.setAdresse(adresse);
*/
//adresses.add(adresse);

// DO SOMETHING W/ THE CONNECTION

 //   public Set<Lieu> readAll() {
        //List<Lieu> lieux = new ArrayList<>();
        //String QUERY = "SELECT * FROM LIEU l JOIN ADRESSE a ON l.adresse_id = a.id";
        //List<Map<String,Object>> items = jdbcTemplate.queryForList(QUERY);
/*
        for (Map<String, Object> item: items) {
            Lieu lieu = new Lieu();
            Adresse adresse = new Adresse();
            lieu.setId((int)item.get("id"));
            lieu.setNom((String)item.get("nom"));
            adresse.setId((int)item.get("adresse_id"));
            adresse.setNumero((int)item.get("numero"));
            adresse.setRue((String)item.get("rue"));
            adresse.setCodePostal((int)item.get("code_postal"));
            adresse.setVille((String)item.get("ville"));
            lieu.setAdresse(adresse);

            lieux.add(lieu);
        }
        return Set.copyOf(lieux);
    }
*/