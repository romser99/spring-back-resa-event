package fr.solutec.re.services;

import fr.solutec.re.dao.LieuDAO;
import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Lieu;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
@Service

public class LieuService {

    private LieuDAO lieuDAO ;
    private AdresseService adresseService ;

    public LieuService(LieuDAO lieuDAO,AdresseService adresseService) {
        this.lieuDAO = lieuDAO;
        this.adresseService = adresseService ;
    }

    public void create(Lieu lieu){
        Adresse adresse = this.adresseService.create(lieu.getAdresse());
        lieu.setAdresse(adresse);
        this.lieuDAO.create(lieu);

    }

    public Lieu read(int id){
        Lieu lieu = this.lieuDAO.read(id) ;
        return lieu ;

    }

    public Set<Lieu> search(Map<String, String> params){
        return this.lieuDAO.search(params) ;
    }

    public void delete(int id){
        this.lieuDAO.delete(id);

    }
}
