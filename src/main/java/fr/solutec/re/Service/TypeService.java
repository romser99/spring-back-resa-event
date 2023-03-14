package fr.solutec.re.Service;

import fr.solutec.re.DAO.EvenementDAO;
import fr.solutec.re.DAO.TypeDAO;
import fr.solutec.re.entites.Evenement;
import fr.solutec.re.entites.Type;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class TypeService {
    private TypeDAO typeDAO;

    public TypeService(TypeDAO typeDAO) {
        this.typeDAO = typeDAO;
    }

    public void create(Type type) {
        System.out.println("[service]Création d'un nouveau type");
        this.typeDAO.create(type);
    }
    public Set<Type> readAll() {
        System.out.println("[service]Lecture des types");

        return this.typeDAO.readAll();
    }


}
