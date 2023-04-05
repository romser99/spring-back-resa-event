package fr.solutec.resaevent.services;


import fr.solutec.resaevent.dao.ClientDAO;
import fr.solutec.resaevent.entites.Client;
import fr.solutec.resaevent.entites.Role;
import fr.solutec.re.entites.UserRole;
import fr.solutec.resaevent.repository.ClientRepository;
import fr.solutec.resaevent.repository.RoleRepository;
import fr.solutec.resaevent.repository.UserRoleRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.net.BindException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

@CrossOrigin
@Service
public class ClientService {
    private ClientDAO clientDAO ;
    private ClientRepository clientRepository ;
    private RoleRepository roleRepository;
    private UserRoleRepository userRoleRepository;

    public ClientService(ClientDAO clientDAO, ClientRepository clientRepository, RoleRepository roleRepository, UserRoleRepository userRoleRepository) {
        this.clientDAO = clientDAO;
        this.clientRepository = clientRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;

    }

    public void save(Client client) throws BindException, NoSuchAlgorithmException {
        String Email = client.getEmail();
        String password = client.getPassword();
        int strength = 10; // work factor of bcrypt
        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(strength, new SecureRandom());
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        client.setPassword(encodedPassword);

        Optional<Client> optionalclient = this.clientRepository.findByEmail(Email);
        if (Email == null || password == null){
            String message = "Veuillez remplir tout les champs obligatoires indiqués par *";
            throw new IllegalStateException(message) ;
        }
        if (optionalclient.isPresent()) {
            String message = String.format ("Un compte est déja associé au mail %s", Email);
            throw new BindException(message) ;

        }
        this.clientDAO.create(client);
        Optional<Client> newoptclient = clientRepository.findByEmail(Email);
        Client newclient = newoptclient.get();
        Optional<Role> newoptrole = roleRepository.findByLibelle("CLIENT");
        Role newRole = newoptrole.get();
        UserRole defaultrole = new UserRole();
        defaultrole.setUser_id(newclient.getId());
        defaultrole.setRole_id(newRole.getId());
        this.userRoleRepository.save(defaultrole);
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
