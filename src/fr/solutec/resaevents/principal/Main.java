package fr.solutec.resaevents.principal;

import fr.solutec.resaevents.dao.AdresseDAO;
import fr.solutec.resaevents.entites.Adresse;
import fr.solutec.resaevents.entites.Client;
import fr.solutec.resaevents.entites.Lieu;
import fr.solutec.resaevents.services.AdresseService;
import fr.solutec.resaevents.services.ClientService;
import fr.solutec.resaevents.services.LieuService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import java.util.Arrays;
import java.util.List;

public class Main {

    /// ADRESSE ///

    /* public static void main(String[] args) throws IOException, SQLException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Veuillez taper 1 pour rentrer une adresse ou 2 pour voir la liste des adresses");
        String reponse = reader.readLine();

        AdresseService adresseService1 = new AdresseService();
        List<Adresse> alladresses = adresseService1.read();

        if (reponse.equals("2")) {

            for (Adresse adres : alladresses) {
                System.out.println(adres.getNumero() + " " + adres.getRue() + " " + adres.getCodePostal() + " " + adres.getVille() + " " + adres.getRegion() + " " + adres.getPays());
            }
        }

        if (reponse.equals("1")) {
            for (int i = 0; i < 1; i++) {
                // Lire les saisies de l'utilisateur

                Adresse adresse = new Adresse();

                System.out.println("Veuillez saisir votre code postal");
                String codePostal = reader.readLine();
                int codePostAsInteger = Integer.parseInt(codePostal);
                adresse.setCodePostal(codePostAsInteger);

                System.out.println("Veuillez saisir votre ville");
                String ville = reader.readLine();
                adresse.setVille(ville);

                System.out.println("Veuillez saisir votre rue");
                String rue = reader.readLine();
                adresse.setRue(rue);

                System.out.println("Veuillez saisir votre numero de rue");
                String numero = reader.readLine();
                int numeroAsInt = Integer.parseInt(numero);
                adresse.setNumero(numeroAsInt);

                System.out.println("Veuillez saisir votre region");
                String region = reader.readLine();
                adresse.setRegion(region);

                System.out.println("Veuillez saisir votre pays");
                String pays = reader.readLine();
                adresse.setPays(pays);


                // et créer une adresse
                AdresseService adresseService = new AdresseService();
                adresseService.create(adresse);

            } */

    /// LIEU ///
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Veuillez taper 1 pour rentrer un lieu, 2 pour voir la liste des lieu ou 3 pour mettre à jour un lieu");
        String reponse = reader.readLine();


        if (reponse.equals("2")) {

            System.out.println("Veuillez saisir l'id du lieu");
            String lieuid = reader.readLine();
            int lieuIdAsInt = Integer.parseInt(lieuid);

            LieuService lieuService = new LieuService();
            List<Lieu> lieux = lieuService.read(lieuIdAsInt);

            for (Lieu lieu : lieux) {

                System.out.println("Le lieu avec l'ID " + lieu.getId() + " se nomme " + lieu.getNom() + " et se trouve à l'adresse "
                        + lieu.getAdresse().getId() + " " + lieu.getAdresse().getNumero() + " " + lieu.getAdresse().getRue() + " " + lieu.getAdresse().getCodePostal()
                        + " " + lieu.getAdresse().getVille() + " " + lieu.getAdresse().getRegion() + " " + lieu.getAdresse().getPays());
            }
        }

        if (reponse.equals("4")) {

            LieuService lieuService = new LieuService();
            List<Lieu> lieux = lieuService.readlieu();

            for (Lieu lieu : lieux) {

                System.out.println("Le lieu avec l'ID " + lieu.getId() + " se nomme " + lieu.getNom());
            }
        }

        if (reponse.equals("1")) {
            for (int i = 0; i < 1; i++) {
                // Lire les saisies de l'utilisateur

                Lieu lieu = new Lieu();

                System.out.println("Veuillez saisir le nom du lieu");
                String lieusaisi = reader.readLine();
                lieu.setNom(lieusaisi);


                // créer un lieu
                LieuService lieuService = new LieuService();
                lieuService.create(lieu);
            }

        }

        // update
        if (reponse.equals("3")) {
            LieuService lieuService = new LieuService();

            System.out.println("Veuillez saisir l'id du lieu");
            String lieuupdate = reader.readLine();
            int lieuIdAsInt = Integer.parseInt(lieuupdate);

            System.out.println("Veuillez saisir l'id de l'adresse");
            String adresseupdate = reader.readLine();
            int adresseIdAsInt = Integer.parseInt(adresseupdate);

            LieuService lieuService1 = new LieuService();
            lieuService.update(lieuIdAsInt, adresseIdAsInt);

        }
    }
}




/*    public static void main(String[] args){

                public static void main (String[]args) throws IOException {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                    // afficher l'instruction
                    System.out.println("Veuillez saisir votre nom");
                    String nom = reader.readLine();
                    System.out.println("Veuillez saisir votre prenom");
                    String prenom = reader.readLine();
                    System.out.println("Veuillez saisir votre mot de passe");
                    String mdp = reader.readLine();
                    System.out.println("Veuillez saisir votre mail");
                    String mail = reader.readLine();
                    System.out.println("Veuillez saisir votre numero de telephone");
                    String telephone = reader.readLine();

                    // creer le client
                    ClientService clientService = new ClientService();
                    Client client = new Client();
                    client.setNom(nom);
                    client.setNom(prenom);
                    client.setNom(mdp);
                    client.setNom(mail);
                    client.setNom(telephone);
                    Client clientCree = clientService.create(client);

            /* System.out.println("Liste de clients");
            ClientService clientService = new ClientService();
            List<Client> clients = clientService.list();
            for (Client client : clients) {
            System.out.println("Le client " + client.getNom() + " a pour id " + client.getId());
            } */

            //afficher

            //  System.out.println("le client cree " + clientCree.getNom() + " a pour id " + clientCree.getId());




// ROLE

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