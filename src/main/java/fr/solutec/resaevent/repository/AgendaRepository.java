package fr.solutec.resaevent.repository;

import fr.solutec.resaevent.entites.Agenda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends CrudRepository<Agenda, Integer> {

}
