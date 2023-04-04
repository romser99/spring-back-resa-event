package fr.solutec.re.service;
import fr.solutec.re.dao.AgendaDAO;
import fr.solutec.re.entites.Agenda;
import fr.solutec.re.entites.Evenement;
import fr.solutec.re.entites.Lieu;
import fr.solutec.re.repositories.AgendaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AgendaService {
    private AgendaRepository agendaRepository;

    private AgendaDAO agendaDAO;
    public AgendaService(AgendaRepository agendaRepository, AgendaDAO agendaDAO) {
        this.agendaRepository = agendaRepository;
        this.agendaDAO = agendaDAO;
    }
    //SEARCH
    public Iterable<Agenda> findAll() {
        return this.agendaRepository.findAll();
    }
    //READ

    public Set<Agenda> readparevt(int idevt) {
        return this.agendaDAO.readparevt(idevt);
    }
    public Agenda findById(int id) {
        Optional<Agenda> optionalAgenda = this.agendaRepository.findById(id);
        if(optionalAgenda.isEmpty()){
            //%S = PLACE HOLDER --> VARIABLE
            String message = String.format("Aucun agenda n'a l'id %s", id);
            throw new IllegalArgumentException(message);
        }
        return optionalAgenda.get();
    }
    //CREATE + UPDATE
    public Agenda save(Agenda agenda){
        return this.agendaRepository.save(agenda);
    }
    //DELETE
    public Agenda deleteById(int id){
        this.agendaRepository.deleteById(id);
        return null;
    }
}
