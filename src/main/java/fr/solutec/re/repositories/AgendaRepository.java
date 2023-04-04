package fr.solutec.re.repositories;

import fr.solutec.re.entites.Agenda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends CrudRepository<Agenda, Integer> {

}
