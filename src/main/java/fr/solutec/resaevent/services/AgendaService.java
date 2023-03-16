package fr.solutec.resaevent.services;
import fr.solutec.resaevent.entites.Agenda;
import fr.solutec.resaevent.repository.AgendaRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class AgendaService {
    private AgendaRepository agendaRepository;
    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }
    //SEARCH
    public Iterable<Agenda> findAll() {
        return this.agendaRepository.findAll();
    }
    //READ
    public Optional<Agenda> findById(int id) {
        return this.agendaRepository.findById(id);
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
