package fr.solutec.resaevent.services;
import fr.solutec.resaevent.entites.Agenda;
import fr.solutec.resaevent.entites.Lieu;
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
    public Iterable<Agenda> findByEvenementId(Integer idevt) {
        return this.agendaRepository.findByEvenementId(idevt);
    }
}
