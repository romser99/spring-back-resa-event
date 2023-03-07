package fr.solutec.resaevents.principal;

import fr.solutec.resaevents.entites.Role;
import fr.solutec.resaevents.entites.Type;
import fr.solutec.resaevents.services.RoleService;
import fr.solutec.resaevents.services.TypeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static fr.solutec.resaevents.enums.RoleEnum.*;

// EXEMPLE ROLES

 public class Main {
    /* public static void main(String[] args) {
        Role role = new Role();
        role.setLibelle("ADMIN");
        RoleService roleService = new RoleService();
        Role resultat = roleService.create(role);
        roleService.display(resultat);

        Role user = new Role();
        user.setLibelle("USER");
        resultat = roleService.create(user);
        roleService.display(resultat);
    }*/

    /*public static void main(String[] args) throws IOException {
       /* // demander le libelle
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // afficher l'instruction
        System.out.println("Veuillez saisir le libelle du role a creer");
        String libelle = reader.readLine();

        // creer le role
        RoleService roleService = new RoleService();
        Role role = new Role();
        role.setLibelle(libelle);
        Role roleCree = roleService.create(role);
        */

       /* System.out.println("Liste de roles");
        RoleService roleService = new RoleService();
        List<Role> roles = roleService.list();
        /*for (int i = 0; i < roles.size(); i**) {
        System.out.println("Le role" + roles.get(i).getLibelle() + "a pour id" + roles.get(i).getId());
        }*/

        /*for (Role role : roles) {
    System.out.println("Le role " + role.getLibelle() + " a pour id " + role.getId());
        }*/

        // afficher

     //  System.out.println("le role cree " + roleCree.getLibelle() + " a pour id " + roleCree.getId());

       /* Role role = roleService.read(GESTIONNAIRE);
       // afficher role et id dans console
        if (role == null) {
            System.out.println("Le role recherche n'existe pas");
        } else if (role.getId() < 100) {
            System.out.println("Le role " + role.getLibelle() + " a pour id " + role.getId() + " <100 ");
        } else {
            System.out.println("Le role " + role.getLibelle() + " a pour id " + role.getId());
        }

    }
    */
    public static void main(String[] args) {
        






    }
}


//public class Main {
    /*public static void main(String[] args) {
        Evenement evenement = new Evenement();
        evenement.setNom("Concert1");
        EvenementService evenementService = new EvenementService();
        Evenement resultat = evenementService.create(evenement);
        evenementService.display(resultat);
    } */



    /*public static void main(String[] args) {
        Type type = new Type();
        type.setNom("Concert");
        TypeService typeService = new TypeService();
        Type resultat = typeService.create(type);
        typeService.display(resultat);}
}*/