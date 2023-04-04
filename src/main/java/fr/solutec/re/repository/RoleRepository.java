package fr.solutec.re.repository;


import fr.solutec.re.entites.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;
@CrossOrigin
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByLibelle(String Libelle);
}
