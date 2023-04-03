package fr.solutec.re.service;

import fr.solutec.re.repositories.LieuRepository;
import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Lieu;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class LieuService {

    LieuRepository lieuRepository;
    AdresseService adresseService;

    public LieuService(LieuRepository lieuRepository, AdresseService adresseService) {
        this.lieuRepository = lieuRepository;
        this.adresseService = adresseService;
    }

    public void create(Lieu lieu) {
        Adresse adresse = this.adresseService.create(lieu.getAdresse());
        lieu.setAdresse(adresse);
        this.lieuRepository.save(lieu);
    }

    public Lieu read(int id) {
        Optional<Lieu> optionalLieu = this.lieuRepository.findById(id); // peut-être qu'il n'y a pas de lieu correspondant
        //// gestion de l'erreur
        if(optionalLieu.isEmpty()) {
            String message = String.format("Aucun lieu n'a l'id %s", id);
            throw new IllegalArgumentException();
        }
        return optionalLieu.get();
    }

    public Set<Lieu> search(Map<String, String> params) {
        return null; //return this.lieuDAO.search
    }
}
