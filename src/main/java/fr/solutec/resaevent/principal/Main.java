package fr.solutec.resaevent.principal;

import fr.solutec.resaevent.dao.AdresseDAO;
import fr.solutec.resaevent.entites.Adresse;
import fr.solutec.resaevent.entites.Lieu;
import fr.solutec.resaevent.services.AdresseService;
import fr.solutec.resaevent.services.LieuService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

import static fr.solutec.resaevent.enums.RoleEnum.GESTIONNAIRE;

public class Main {}
    /*
public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //CODE MAIN ADRESSE
    AdresseService adresseService = new AdresseService(AdresseDAO adresseDAO);
    Set<Adresse> adresseList = adresseService.readAll();
    Adresse adresse = new Adresse();

    System.out.println("Veuillez-saisir l'option de travail souhaité " +
            "(1 -> Lire une adresse ; 2 -> Enregistrer une adresse ; 3 -> Enregistrer un lieu & lire son adresse = ");
    String num = reader.readLine();
    int numAsInteger = Integer.parseInt(num);

    if (numAsInteger == 1) {

        for (Adresse adresseId : adresseList) {

            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //System.out.println("Veuillez-saisir l'id de l'utilisateur ");
            //String id = reader.readLine();
            //int idAsInteger = Integer.parseInt(id);
            //adresse.setId(idAsInteger);
            //adresseService.getOne(idAsInteger);

            //System.out.println(" ADRESSE = " + adresseId.getNumero() + " " + adresseId.getRue() + " " + adresseId.getCodePostal() + " " + adresseId.getVille() + " " + adresseId.getRegion());
        }

    } else if (numAsInteger == 2) {

        for (int i = 1; i < 2; i++) {
    /*
   LIRE LES SAISIES DE LUTILSATEUR

            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Veuillez-saisir le code postal ");
            String codePostal = reader.readLine();
            //cast string to int
            int codePostAsInteger = Integer.parseInt(codePostal);
            adresse.setCodePostal(codePostAsInteger);
/*


            System.out.println("Veuillez-saisir la ville ");
            String ville = reader.readLine();
            adresse.setVille(ville);

            System.out.println("Veuillez-saisir la région ");
            String region = reader.readLine();
            adresse.setRegion(region);

            System.out.println("Veuillez-saisir le numéro de rue ");
            String numero = reader.readLine();
            //cast string to int
            int numeroAsInteger = Integer.parseInt(numero);
            adresse.setNumero(numeroAsInteger);

            System.out.println("Veuillez-saisir la rue ");
            String rue = reader.readLine();
            adresse.setRue(rue);

            adresseService.create(adresse);
            }

    } else if (numAsInteger == 3) {
        //CODE MAIN LIEU
        LieuService lieuService = new LieuService();
        List<Lieu> lieuList = lieuService.read();
        Lieu lieu = new Lieu();

        for (int i = 1; i < 2; i++) {
            System.out.println("Veuillez-saisir le nom du lieu = ");
            String nom = reader.readLine();
            lieu.setNom(nom);
            int lieuId = lieuService.create(lieu);
            System.out.println("Veuillez-saisir l'id de l'adresse = ");
            String idAdresse = reader.readLine();
            int idAdresseAsInteger = Integer.parseInt(idAdresse);
            lieu.setIdAdresse(idAdresseAsInteger);
            lieuService.update(lieuId, lieu.getNom(),lieu.getIdAdresse());
            System.out.println(lieuId+ " " + lieu.getNom()+ " " + lieu.getIdAdresse());
        }

        for (Lieu lieuId : lieuList) {

            System.out.println("Veuillez-saisir l'id de l'utilisateur ");
            String id = reader.readLine();
            int idAsInteger = Integer.parseInt(id);
            adresse.setId(idAsInteger);
            lieu.setIdAdresse(idAsInteger);

            System.out.println("Veuillez-saisir l'id du lieu = ");
            String idAdresse = reader.readLine();
            int idAdresseAsInteger = Integer.parseInt(idAdresse);
            lieu.setIdAdresse(idAdresseAsInteger);

            System.out.println(" Lieu = " + lieu.getNom()
                    +" ID Adresse = " + idAdresseAsInteger + " Adresse = "
                    + lieu.getAdresse().getNumero()+ " " + lieu.getAdresse().getRue()+ " "
                    + lieu.getAdresse().getCodePostal()+" "+ lieu.getAdresse().getVille()+" "+ lieu.getAdresse().getRegion());
            }
        }
    }
}
  */


/*
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
        Role role = new Role();
        role.setLibelle(libelle);
        Role roleCree = roleService.create(role);


        // afficher le role et son id dans la console remettre commentaire !!!!



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

        remettre commentaire !!!!

        Role role = roleService.read(GESTIONNAIRE) ;
        if( role == null){
            System.out.println("Le role recherché n'existe pas");

        } else if(role.getId() <100) {
            System.out.println("Le role " + role.getLibelle() + " a pour id " + role.getId() + " qui est inférieur à 100");

        } else {
            System.out.println("Le role " + role.getLibelle() + " a pour id " + role.getId());
        }
*/
