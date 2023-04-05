package fr.solutec.resaevent.dao;
import fr.solutec.resaevent.entites.Place;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class PlaceDAO {/*
    private JdbcTemplate jdbcTemplate;

    public PlaceDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Place create(Place place) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        System.out.println("Creation d'une nouvelle placee");
        this.jdbcTemplate.update((connection) -> {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO place (categorie, quantite, prix) VALUES(?,?,?)", 1);
            ps.setString(1, place.getCategorie());
            ps.setInt(2, place.getQuantite());
            ps.setInt(3, place.getPrix());
            return ps;
        }, keyHolder);
        int id = keyHolder.getKey().intValue();
        place.setId(id);
        return place;
    }

    public Set<Place> readAll() {
        List<Place> places = new ArrayList();
        String QUERY = "SELECT * FROM PLACE";
        List<Map<String, Object>> items = this.jdbcTemplate.queryForList(QUERY);
        Iterator var4 = items.iterator();

        while(var4.hasNext()) {
            Map<String, Object> item = (Map)var4.next();
            Place place = new Place();
            place.setId((Integer)item.get("id"));
            place.setCategorie((String)item.get("categorie"));
            place.setQuantite((Integer)item.get("quantite"));
            place.setPrix((Integer)item.get("prix"));
            places.add(place);
        }

        return Set.copyOf(places);
    }*/
}