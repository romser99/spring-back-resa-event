package fr.solutec.re.services;

import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Lieu;
import fr.solutec.re.repository.LieuRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LieuService {
    private LieuRepository lieuRepository;
    private AdresseService adresseService;

    public LieuService(LieuRepository lieuRepository, AdresseService adresseService) {
        this.lieuRepository = lieuRepository;
        this.adresseService = adresseService;
    }

    public void create(Lieu lieu) {
        System.out.println("[Service] Création nouveau lieu");
        Adresse adresse = this.adresseService.create(lieu.getAdresse());
        lieu.setAdresse(adresse);
        this.lieuRepository.save(lieu);
    }

    public Iterable<Lieu> readAll () {
        System.out.println("[Service] Lecture des lieux");
        return this.lieuRepository.findAll();
    }


    public Lieu read(int id) {
        System.out.println("[Service] Lecture dues lieu");
        Optional<Lieu> optionalLieu = this.lieuRepository.findById(id);
        return optionalLieu.get();
    }


    public void delete(int id) {
        System.out.println("[Service] Supression ancien lieu");
        this.lieuRepository.deleteById(id);

    }


    public Iterable<Lieu> search(List<String> params) {
        System.out.println("[Service] Recherche du lieu");
        return this.lieuRepository.findByNomAndRueAndVilleAndRegion(params.get(0),params.get(1),params.get(2),params.get(3));
    }


}


