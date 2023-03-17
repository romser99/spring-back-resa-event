package fr.solutec.re.services;

import fr.solutec.re.dao.LieuDAO;
import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Lieu;
import fr.solutec.re.repository.LieuRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
@Service

public class LieuService {

    private LieuDAO lieuDAO ;
    private LieuRepository lieuRepository ;
    private AdresseService adresseService ;

    public LieuService(LieuDAO lieuDAO, LieuRepository lieuRepository, AdresseService adresseService) {
        this.lieuDAO = lieuDAO;
        this.lieuRepository = lieuRepository;
        this.adresseService = adresseService;
    }

    public void save(Lieu lieu) {
        //Appel de la méthode create qui est dans lieuRepository
        Adresse adresse = this.adresseService.findById(lieu.getAdresse().getId());
        lieu.setAdresse(adresse);
        this.lieuRepository.save(lieu);
    }

    public Lieu read(int id){
        Optional<Lieu> optionalLieu = this.lieuRepository.findById(id) ;
        if (optionalLieu.isEmpty()){
            String message = String.format ("Aucun lieu n'a l'id %s", id);
            throw new IllegalArgumentException(message) ;
        }
        return optionalLieu.get() ;

    }

    public Iterable<Lieu> findall(){
        return this.lieuRepository.findAll();
    }

    public Set<Lieu> search(Map<String, String> params){
        return this.lieuDAO.search(params) ;
    }

    public void delete(int id){
        this.lieuRepository.deleteById(id);

    }
}
