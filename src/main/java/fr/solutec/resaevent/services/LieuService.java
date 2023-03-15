package fr.solutec.resaevent.services;

import fr.solutec.resaevent.dao.AdresseDAO;
import fr.solutec.resaevent.entites.Adresse;
import fr.solutec.resaevent.entites.Agenda;
import fr.solutec.resaevent.entites.Lieu;
import fr.solutec.resaevent.dao.LieuDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class LieuService {
    private LieuDAO lieuDAO;
    private AdresseService adresseService;

    public LieuService(LieuDAO lieuDAO, AdresseService adresseService) {
        this.lieuDAO = lieuDAO;
        this.adresseService = adresseService;
    }
    public void create(Lieu lieu) {
        //Appel de la méthode create qui est dans LieuDAO
        Adresse adresse = this.adresseService.create(lieu.getAdresse());
        lieu.setAdresse(adresse);
        this.lieuDAO.create(lieu);
    }
    public Lieu read(int id){
        Lieu lieu = this.lieuDAO.read(id);
        return lieu;
    }
    public Set<Lieu> search(Map<String, String> params){
        return this.lieuDAO.search(params);
    }

    public Lieu update(Lieu lieu) {
        return this.lieuDAO.update(lieu);
    }
}

