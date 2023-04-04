package fr.solutec.re.repository;

import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.MyUserDetails;
import fr.solutec.re.entites.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin
public interface UserRepository extends CrudRepository<MyUserDetails, Integer> {
    Optional<MyUserDetails> findByEmail(String Email);
}
