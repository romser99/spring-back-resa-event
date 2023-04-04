package fr.solutec.re.dao;

import fr.solutec.re.entites.Agenda;
import fr.solutec.re.entites.Evenement;
import fr.solutec.re.entites.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Component
public class AgendaDAO {

    public JdbcTemplate jdbcTemplate;

    public AgendaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Set<Agenda> readparevt(int idevt) {
        if (idevt != 0) {
            List<Agenda> agendas = new ArrayList<>();
            String QUERY = "SELECT a.id as a_id, a.date_debut as a_date_debut, a.date_fin as a_date_fin, a.horaire_debut as a_horaire_debut, a.horaire_fin as a_horaire_fin FROM AGENDA a JOIN EVENEMENT e ON a.id_evenement = e.id WHERE e.id = ?";
            List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY, idevt);
            for (Map<String, Object> item : items) {
                Agenda agenda = new Agenda();

                agenda.setId((int) item.get("a_id"));
                agenda.setDateDebut((Date) item.get("a_date_debut"));
                agenda.setDateFin((Date) item.get("a_date_fin"));
                agenda.setHoraireDebut((Time) item.get("a_horaire_debut"));
                agenda.setHoraireFin((Time) item.get("a_horaire_fin"));
                agendas.add(agenda);
            }
            return Set.copyOf(agendas);
        } else {
            return null;
        }
    }
}
