package fr.solutec.resaevent.dao;

import java.sql.*;
import fr.solutec.resaevent.entites.Adresse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

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
    public Adresse create(Adresse adresse) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO ADRESSE(NUMERO, RUE, CODE_POSTAL, VILLE, REGION, PAYS) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, adresse.getNumero());
            ps.setString(2, adresse.getRue());
            ps.setInt(3, adresse.getCodePostal());
            ps.setString(4, adresse.getVille());
            ps.setString(5, adresse.getRegion());
            ps.setString(6, adresse.getPays());
            return ps;
            }, keyHolder);

        int id = keyHolder.getKey().intValue();
        adresse.setId(id);
        return adresse;
    }
    public Set<Adresse> readAll() {

        List<Adresse> adresses = new ArrayList<>();
        ///READ DANS LA BDD
            // REQUETE
            String QUERY = "SELECT * FROM ADRESSE";
            //PREPARATION DE LA REQUETE

            //DEFINTION DE LA VARIABLE
            List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
            for (Map<String, Object> item : items) {
                Adresse adresse = new Adresse();
                adresse.setId((int) item.get("id"));
                adresse.setNumero((int) item.get("numero"));
                adresse.setRue((String) item.get("rue"));
                adresse.setCodePostal((int) item.get("code_postal"));
                adresse.setVille((String) item.get("ville"));
                adresse.setRegion((String) item.get("region"));
                adresse.setPays((String) item.get("pays"));
                adresses.add(adresse);
            }
        return Set.copyOf(adresses);
    }
}
//

/*

public class AdresseDAO {

    public List<Adresse> read() {
        List<Adresse> adresses = new ArrayList<>();
        ///INSERT DANS LA BDD
        try {
            //PROTOCOL//[HOSTS][/DATABASE][?PROPERTIES]
            String CONNECTION_URL = "jdbc:mysql://localhost:3306/resaevents?user=root&password=";
            connection = DriverManager.getConnection(CONNECTION_URL);
            // REQUETE
            String QUERY = "SELECT * FROM ADRESSE";
            //PREPARATION DE LA REQUETE
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            //DEFINTION DE LA VARIABLE

            //EXECUTION DE LA REQUETE
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Adresse adresse = new Adresse();
                adresse.setId(resultSet.getInt(1));
                adresse.setNumero(resultSet.getInt(2));
                adresse.setRue(resultSet.getString(3));
                adresse.setCodePostal(resultSet.getInt(4));
                adresse.setVille(resultSet.getString(5));
                adresse.setRegion(resultSet.getString(6));
                adresses.add(adresse);
            }
            // DO SOMETHING W/ THE CONNECTION

            connection.close();

        } catch (SQLException ex) {
            //HANDLE ANY ERRORS
            System.out.println("SQLException" + ex.getMessage());
            System.out.println("SQLState" + ex.getSQLState());
            System.out.println("VendorError" + ex.getErrorCode());
        }
        return adresses;
    }
    public List<Adresse> getOne(int id) {
        List<Adresse> adresses = new ArrayList<>();
        ///INSERT DANS LA BDD
        try {
            //PROTOCOL//[HOSTS][/DATABASE][?PROPERTIES]
            String CONNECTION_URL = "jdbc:mysql://localhost:3306/resaevents?user=root&password=";
            connection = DriverManager.getConnection(CONNECTION_URL);
            // REQUETE
            String QUERY = "SELECT * FROM ADRESSE WHERE ID =?";
            //PREPARATION DE LA REQUETE
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            //DEFINTION DE LA VARIABLE
            preparedStatement.setInt(1, id);
            //EXECUTION DE LA REQUETE
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Adresse adresse = new Adresse();
                adresse.setId(resultSet.getInt(1));
                adresse.setNumero(resultSet.getInt(2));
                adresse.setRue(resultSet.getString(3));
                adresse.setCodePostal(resultSet.getInt(4));
                adresse.setVille(resultSet.getString(5));
                adresse.setRegion(resultSet.getString(6));
                adresses.add(adresse);
            }
            // DO SOMETHING W/ THE CONNECTION

            connection.close();

        } catch (SQLException ex) {
            //HANDLE ANY ERRORS
            System.out.println("SQLException" + ex.getMessage());
            System.out.println("SQLState" + ex.getSQLState());
            System.out.println("VendorError" + ex.getErrorCode());
        }
        return adresses;
    }

}



   List<Adresse> adresses = new ArrayList<>();
        //String QUERY = "SELECT * FROM ADRESSE";
            List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
            for (Map<String, Object> item: items){
                Adresse adresse = new Adresse();
                adresse.setId((int)item.get("id"));
                adresse.setNumero((int)item.get("numero"));
                adresse.setRue((String) item.get("rue"));
                adresses.add(adresse);
            }
            return Set.copyOf(adresses);
        }
}

 */
