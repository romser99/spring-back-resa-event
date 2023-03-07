package fr.solutec.resaevent.principal;

import fr.solutec.resaevent.services.RoleService;
import fr.solutec.resaevent.entites.Role;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static fr.solutec.resaevent.enums.RoleEnum.GESTIONNAIRE;

public class Main {
    public static void main(String[] args) throws IOException {
        // demander le libelle d'un role à l'utilisateur
        /**
         * classe buffered reader
         * objet (instance de classe reader on peut nommer si on veut
         * nom clé permet de creer l'objetinstance del al classe en passant les parametres
         */
        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // afficher l'instruction

        System.out.println("veuiller saisir le libelle du role à créer");
        String libelle = reader.readLine();

        //creer le role

        RoleService roleService = new RoleService() ;
        Role role = new Role() ;
        role.setLibelle(libelle);
        Role roleCree = roleService.create(role);


        // afficher le role et son id dans la console
        */
        System.out.println("Liste de roles");
        RoleService roleService = new RoleService();
        /*
        List<Role> roles = roleService.list();
        for (int i = 0; i< roles.size(); i++) {
            System.out.println("Le role " + roles.get(i).getLibelle() + " a pour id " + roles.get(i).getId() );

        }

        for (Role role : roles) {
            System.out.println("Le role " + role.getLibelle() + "a pour id " + role.getId() );
        }
        */

        Role role = roleService.read(GESTIONNAIRE) ;
        if( role == null){
            System.out.println("Le role recherché n'existe pas");

        } else if(role.getId() <100) {
            System.out.println("Le role " + role.getLibelle() + " a pour id " + role.getId() + " qui est inférieur à 100");

        } else {
            System.out.println("Le role " + role.getLibelle() + " a pour id " + role.getId());
        }


    }
}