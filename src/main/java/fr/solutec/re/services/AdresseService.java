package fr.solutec.re.services;

import fr.solutec.re.dao.AdresseDAO;
import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Lieu;
import fr.solutec.re.repository.AdresseRepository;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.Set;
@Service


public class AdresseService {
    private AdresseDAO adresseDAO ;
    private AdresseRepository adresseRepository;

    public AdresseService(AdresseDAO adresseDAO, AdresseRepository adresseRepository) {
        this.adresseDAO = adresseDAO;
        this.adresseRepository = adresseRepository;
    }

    public Adresse save(Adresse adresse){
        System.out.println("[service]creation d'une nouvelle adresse");
        return this.adresseRepository.save(adresse);

    }

    public Iterable<Adresse> findAll(){
        System.out.println("lecture des adresses");
        return this.adresseRepository.findAll();

    }

    public Adresse findById(int id){
        Optional<Adresse> optionalAdresse = this.adresseRepository.findById(id) ;
        if (optionalAdresse.isEmpty()){
            String message = String.format ("Aucune adresse n'a l'id %s", id);
            throw new IllegalArgumentException(message) ;
        }
        return optionalAdresse.get() ;

    }

    public void delete(int id){
        this.adresseRepository.deleteById(id);

    }
}
