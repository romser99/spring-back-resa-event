package fr.solutec.re.services;

import fr.solutec.re.DAO.QRCodeDAO;
import fr.solutec.re.entites.QRCode;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class QRCodeService {
    private QRCodeDAO qrcodeDAO;
    public QRCodeService(QRCodeDAO qrcodeDAO) {
        this.qrcodeDAO = qrcodeDAO;
    }

    public void create (QRCode qrcode) {
        System.out.println("[Service] Création nouveau qrcode");
        this.qrcodeDAO.create(qrcode);
    }

    public void delete (QRCode qrcode) {
        System.out.println("[Service] Supression ancien qrcode");
        this.qrcodeDAO.delete(qrcode);
    }

    public Set<QRCode> readAll () {
        return this.qrcodeDAO.readAll();
    }
}
