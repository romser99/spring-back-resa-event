package fr.solutec.re.services;

import fr.solutec.re.dao.AdresseDAO;
import fr.solutec.re.entites.Adresse;
import org.springframework.stereotype.Service;


import java.util.Set;
@Service


public class AdresseService {
    private AdresseDAO adresseDAO ;

    public AdresseService(AdresseDAO adresseDAO) {
        this.adresseDAO = adresseDAO;
    }

    public Adresse create(Adresse adresse){
        System.out.println("[service]creation d'une nouvelle adresse");
        return this.adresseDAO.create(adresse);

    }

    public Set<Adresse> readALL(){
        System.out.println("lecture des adresses");
        return this.adresseDAO.readALL();

    }

    public void delete(int id){
        this.adresseDAO.delete(id);

    }
}
