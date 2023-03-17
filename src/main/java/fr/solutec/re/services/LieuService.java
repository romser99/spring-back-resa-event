package fr.solutec.re.services;

import com.sun.istack.NotNull;
import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Lieu;
import fr.solutec.re.repository.LieuRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.BindException;
import java.util.*;

@Service
public class LieuService {
    private LieuRepository lieuRepository;
    private AdresseService adresseService;

    public LieuService(LieuRepository lieuRepository, AdresseService adresseService) {
        this.lieuRepository = lieuRepository;
        this.adresseService = adresseService;
    }

    public void create(Lieu lieu) throws BindException {
        System.out.println("[Service] Création nouveau lieu");
        Adresse adresse = this.adresseService.create(lieu.getAdresse());
        lieu.setAdresse(adresse);
        if (lieuRepository.existsByNomAndNumeroAndRueAndVilleAndRegion(lieu.getNom(), adresse.getNumero(), adresse.getRue(), adresse.getVille(), adresse.getRegion()) == true) {
            String message = String.format("Ce lieu existe déjà dans la base de données");
            throw new BindException(message);
        }
        this.lieuRepository.save(lieu);
    }


    public Iterable<Lieu> readAll () {
        System.out.println("[Service] Lecture des lieux");
        Iterable<Lieu> iterableLieu = this.lieuRepository.findAll();
        if(IterableUtils.size(iterableLieu) == 0) {
            String message = String.format("Il n'existe aucune adresse dans la base de données");
            throw new IllegalArgumentException(message);
        }
        return this.lieuRepository.findAll();
    }


    public Lieu read(int id) {
        System.out.println("[Service] Lecture du lieu");
        Optional<Lieu> optionalLieu = this.lieuRepository.findById(id);
        if(optionalLieu.isEmpty()) {
            String message = String.format("Aucun lieu n'a cet ID %s", id);
            throw new IllegalArgumentException(message);
        }
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


