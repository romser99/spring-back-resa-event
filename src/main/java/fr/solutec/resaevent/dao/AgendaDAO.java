package fr.solutec.resaevent.dao;

import java.sql.*;
import java.sql.Date;
import java.sql.Time;
import fr.solutec.resaevent.entites.Agenda;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class AgendaDAO {
    private JdbcTemplate jdbcTemplate;
    public AgendaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Agenda create(Agenda agenda) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO AGENDA(date_debut, date_fin, horaire_debut, horaire_fin) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setObject(1, agenda.getDateDebut());
            ps.setObject(2, agenda.getDateFin());
            ps.setObject(3, agenda.getHoraireDebut());
            ps.setObject(4, agenda.getHoraireFin());

            return ps;
        }, keyHolder);

        int id = keyHolder.getKey().intValue();
        agenda.setId(id);
        return agenda;
    }
    public Set<Agenda> readAll() {

        List<Agenda> agendas = new ArrayList<>();
        //REQUETE
        String QUERY = "SELECT * FROM AGENDA";
        //PREPARATION DE LA REQUETE

        //DEFINTION DE LA VARIABLE
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item : items) {
            Agenda agenda = new Agenda();
            agenda.setId((Integer) item.get("id"));
            agenda.setDateDebut((LocalDate) item.get("date_debut"));
            agenda.setDateFin((LocalDate) item.get("date_fin"));
            agenda.setHoraireDebut((LocalTime) item.get("horaire_debut"));
            agenda.setHoraireFin((LocalTime) item.get("horaire_fin"));
            agendas.add(agenda);
        }
        return Set.copyOf(agendas);
    }

    public Agenda update(Agenda agenda){

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE AGENDA SET " +
                            "DATE_DEBUT = ?, DATE_FIN = ?, HORAIRE_DEBUT = ?, HORAIRE_FIN = ? " +
                            "WHERE ID = ?");
            ps.setObject(1, agenda.getDateDebut());
            ps.setObject(2, agenda.getDateFin());
            ps.setObject(3, agenda.getHoraireDebut());
            ps.setObject(4, agenda.getHoraireFin());
            ps.setInt(5, agenda.getId());

            return ps;
        });
        return agenda;
    }
    public Agenda delete(Agenda agenda){

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM AGENDA WHERE ID=?");
            ps.setInt(1, agenda.getId());

            return ps;
        });
        return agenda;
    }
}
//

/*

    //public List<Adresse> getOne(int id) {
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

}
 */
