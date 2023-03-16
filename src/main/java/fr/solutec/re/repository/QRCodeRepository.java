package fr.solutec.re.repository;

import fr.solutec.re.entites.QRCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QRCodeRepository extends CrudRepository<QRCode, Integer> {
}
