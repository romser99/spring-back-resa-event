package fr.solutec.resaevent.services;

import fr.solutec.resaevent.dao.AgendaDAO;
import fr.solutec.resaevent.entites.Agenda;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class AgendaService {
    private AgendaDAO agendaDAO;

    public AgendaService(AgendaDAO agendaDAO){
        this.agendaDAO = agendaDAO;
    }
    public Agenda create (Agenda agenda) {
        //Appel de la méthode create qui est dans AgendaDAO
        return this.agendaDAO.create(agenda);
    }
    public Set<Agenda> readAll() {
       return this.agendaDAO.readAll();
    }
    public Agenda update(Agenda agenda) {
        return this.agendaDAO.update(agenda);
    }
    public Agenda delete(Agenda agenda) {
       return this.agendaDAO.delete(agenda);
   }
}
