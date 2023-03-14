package fr.solutec.re.dao;

import fr.solutec.re.entites.Client;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class ClientDAO {


    private JdbcTemplate jdbcTemplate;

    public ClientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create (Client client){
        jdbcTemplate.update(
                "INSERT INTO CLIENT (PRENOM, NOM, MAIL, TELEPHONE, PASSWORD) VALUES(?,?,?,?,?)",
                client.getPrenom(),
                client.getNom(),
                client.getEmail(),
                client.getTelephone(),
                client.getPassword()
        );

    }

    public Set<Client> readALL() {
        List<Client> clients = new ArrayList<>();
        String QUERY = "SELECT * FROM CLIENT";
        List<Map<String,Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item: items) {
            Client client = new Client();
            client.setId((int)item.get("id"));
            client.setPrenom((String)item.get("prenom"));
            client.setNom((String)item.get("nom"));
            client.setEmail((String)item.get("mail"));
            client.setTelephone((String)item.get("telephone"));
            client.setPassword((String)item.get("password"));
            clients.add(client);
        }
        return Set.copyOf(clients);
    }
}
