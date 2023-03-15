package fr.solutec.re.dao;

import fr.solutec.re.entites.Client;
import fr.solutec.re.entites.Lieu;
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

    public Client read(int id) {
        String sql = "SELECT * FROM CLIENT WHERE id=?";
        Client client = jdbcTemplate.queryForObject(sql,Client.class, new Object[] { id });
        return client ;

    }


    public Set<Client> search(Map<String, String> params) {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM CLIENT";
        if (!params.isEmpty()) {
            List<String> keys = List.copyOf(params.keySet());
            for (int i = 0; i < keys.size(); i++) {

                if (i == 0) {
                    query += " WHERE " + keys.get(i) + " LIKE '%" + params.get(keys.get(i))+"%'";
                }
                else {
                    query += " AND " + keys.get(i) + " LIKE '%" + params.get(keys.get(i))+"%'" ;
                }
            }
        }
        List<Map<String,Object>> items = jdbcTemplate.queryForList(query);
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

    public void delete(int id){
        jdbcTemplate.update(
                "DELETE FROM ClIENT WHERE id = ?",
                id);

    }
}
