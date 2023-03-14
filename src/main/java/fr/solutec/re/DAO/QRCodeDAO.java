package fr.solutec.re.DAO;

import fr.solutec.re.entites.QRCode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class QRCodeDAO {
    private JdbcTemplate jdbcTemplate;
    public QRCodeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create (QRCode qrcode) {
        jdbcTemplate.update(
                "INSERT INTO QRCODE (lien) VALUES(?)",
                qrcode.getUrl()
        );
    }


    public void delete (QRCode qrcode) {
        jdbcTemplate.update(
                "DELETE FROM QRCODE WHERE lien=?",
                qrcode.getUrl()
        );
    }

    public Set<QRCode> readAll() {
        List<QRCode> qrcodes = new ArrayList<>();
        String QUERY = "SELECT * FROM QRCODE";
        List<Map<String, Object>> items = jdbcTemplate.queryForList(QUERY);
        for (Map<String, Object> item: items){
            QRCode qrcode = new QRCode();
            qrcode.setId((int)item.get("id"));
            qrcode.setUrl((String)item.get("lien"));

            qrcodes.add(qrcode);
        }
        return Set.copyOf(qrcodes);
    }
}