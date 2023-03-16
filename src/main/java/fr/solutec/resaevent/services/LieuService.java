package fr.solutec.resaevent.services;
import fr.solutec.resaevent.entites.Adresse;
import fr.solutec.resaevent.entites.Lieu;
import fr.solutec.resaevent.repository.LieuRepository;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Optional;

@Service
public class LieuService {
    private LieuRepository lieuRepository;
    private AdresseService adresseService;

    public LieuService(LieuRepository lieuRepository, AdresseService adresseService) {
        this.lieuRepository = lieuRepository;
        this.adresseService = adresseService;
    }
    //SEARCH = FINDALL
    public Iterable<Lieu> findAll(Map<String, String> params){
        return this.lieuRepository.findAll();
    }
    //CREATE + UPDATE = SAVE
    public void save(Lieu lieu) {
        Adresse adresse = this.adresseService.findById(lieu.getAdresse().getId()).get();
        if (adresse.getRue() == null) {
        }
        lieu.setAdresse(adresse);
        this.lieuRepository.save(lieu);
    }
    //READ = FINDBYID
    public Lieu findById(int id){
        Optional<Lieu> optionalLieu = this.lieuRepository.findById(id);
        return optionalLieu.get();
    }
    //DELETE
    public Lieu delete(Lieu lieu) {
        Adresse adresse = this.adresseService.findById(lieu.getAdresse().getId()).get();
        lieu.setAdresse(adresse);
        this.lieuRepository.delete(lieu);
        return null;
    }
}