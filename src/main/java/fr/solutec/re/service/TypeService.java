package fr.solutec.re.service;

import fr.solutec.re.repositories.TypeRepository;
import fr.solutec.re.entites.Type;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

    TypeRepository typeRepository;

    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public void create(Type type) {
        System.out.println("[service] Création d'un nouveau type");
        this.typeRepository.save(type);
    }
    public Iterable<Type> readAll() {
        System.out.println("[service] Lecture des types");
        return this.typeRepository.findAll();
    }

    public void delete(int idtype) {
        System.out.println("[Service] Suppression d'un type");
        this.typeRepository.deleteById(idtype);
    }




}
