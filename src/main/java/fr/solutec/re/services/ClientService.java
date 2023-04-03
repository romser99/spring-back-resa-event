package fr.solutec.re.services;

import fr.solutec.re.dao.ClientDAO;
import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.Gestionnaire;
import fr.solutec.re.repository.ClientRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.net.BindException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

@CrossOrigin
@Service
public class ClientService {
    private ClientDAO clientDAO ;
    private ClientRepository clientRepository ;

    public ClientService(ClientDAO clientDAO, ClientRepository clientRepository) {
        this.clientDAO = clientDAO;
        this.clientRepository = clientRepository;
    }

    public void save(Client client) throws BindException, NoSuchAlgorithmException {
        String Email = client.getEmail();
        String password = client.getPassword();
        int strength = 10; // work factor of bcrypt
        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(strength, new SecureRandom());
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        client.setPassword(encodedPassword);

        /*SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
        String newpassword = new String(hashedPassword, StandardCharsets.UTF_8);
        client.setPassword(newpassword);*/


        Optional<Client> optionalclient = this.clientRepository.findByEmail(Email);
        if (Email == null || password == null){
            String message = "Veuillez remplir tout les champs obligatoires indiqués par *";
            throw new IllegalStateException(message) ;
        }
        if (optionalclient.isEmpty() == false) {
            String message = String.format ("Un compte est déja associé au mail %s", Email);
            throw new BindException(message) ;

        }
        this.clientRepository.save(client);

    }

    public Client findById(int id){
        Optional<Client> optionalclient = this.clientRepository.findById(id);
        if (optionalclient.isEmpty()){
            String message = String.format ("Aucun Client n'a l'id %s", id);
            throw new IllegalArgumentException(message) ;
        }
        return optionalclient.get() ;

    }

    public boolean login(String mail, String password){
        Optional<Client> optionalclientmail = this.clientRepository.findByEmail(mail);
        if (optionalclientmail.isEmpty() == true){
            String message = String.format ("Aucun Client n'a l'email %s", mail);
            throw new IllegalArgumentException(message) ;
        }
        Client client = optionalclientmail.get();
        String Hashpassword = client.getPassword();
        int strength = 10; // work factor of bcrypt
        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(strength, new SecureRandom());
        boolean check = bCryptPasswordEncoder.matches(password, client.getPassword());
        return check;


    }



    public Set<Client> search(Map<String, String> params){
        Map<String, String> nparams =  new HashMap<>();
        for (String key: params.keySet()) {
            if(params.get(key) != null ) {
                nparams.put(key, params.get(key) ) ;
            }
        }

        return this.clientDAO.search(nparams) ;
    }

    public void deleteById(int id){
        Optional<Client> optionalclient = this.clientRepository.findById(id);
        if (optionalclient.isEmpty()){
            String message = String.format ("Aucun Client n'a l'id %s", id);
            throw new IllegalArgumentException(message) ;
        }
        this.clientRepository.deleteById(id);

    }
}
