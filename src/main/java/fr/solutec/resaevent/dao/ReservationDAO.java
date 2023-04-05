package fr.solutec.resaevent.dao;

import java.sql.*;
import java.sql.Date;
import java.sql.Time;
import fr.solutec.resaevent.entites.Agenda;
import fr.solutec.resaevent.entites.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class ReservationDAO {/*
    private JdbcTemplate jdbcTemplate;

    public ReservationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Reservation create(Reservation reservation) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO RESERVATION(date_debut, date_fin, horaire_debut, horaire_fin) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            ps.setA(1, reservation.get());


            return ps;
        }, keyHolder);

        int id = keyHolder.getKey().intValue();
        reservation.setId(id);
        return reservation;
    }

    public Set<Reservation> readAll() {

        List<Reservation> reservationss = new ArrayList<>();
        //REQUETE
        String QUERY = "SELECT * FROM RESERVATION";
        //PREPARATION DE LA REQUETE

        //DEFINTION DE LA VARIABLE
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item : items) {
            Reservation reservation = new Reservation(agenda);
            reservation.setId((Integer) item.get("id"));
            reservation.setDateDebut((Date) item.get("date_debut"));
            reservation.setDateFin((Date) item.get("date_fin"));
            reservation.setHoraireDebut((Time) item.get("horaire_debut"));
            reservation.setHoraireFin((Time) item.get("horaire_fin"));
            reservations.add(reservation);
        }
        return Set.copyOf(reservations);
    }*/
}