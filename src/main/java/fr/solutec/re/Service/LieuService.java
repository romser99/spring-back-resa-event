package fr.solutec.re.Service;

import fr.solutec.re.DAO.LieuDAO;
import fr.solutec.re.entites.Adresse;
import fr.solutec.re.entites.Lieu;
import org.springframework.stereotype.Service;

@Service
public class LieuService {

    LieuDAO lieuDAO;
    AdresseService adresseService;

    public LieuService(LieuDAO lieuDAO, AdresseService adresseService) {
        this.lieuDAO = lieuDAO;
        this.adresseService = adresseService;
    }

    public void create(Lieu lieu) {
        Adresse adresse = this.adresseService.create(lieu.getAdresse());
        lieu.setAdresse(adresse);
        this.lieuDAO.create(lieu);
    }
}
