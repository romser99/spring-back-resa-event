package fr.solutec.re.services;

import fr.solutec.re.repository.QRCodeRepository;
import fr.solutec.re.entites.QRCode;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QRCodeService {
    private QRCodeRepository qrcodeRepository;

    public QRCodeService(QRCodeRepository qrcodeRepository) {
        this.qrcodeRepository = qrcodeRepository;
    }

    public void create (QRCode qrcode) {
        System.out.println("[Service] Création nouveau qrcode");
        this.qrcodeRepository.save(qrcode);
    }

    public Iterable<QRCode> readAll () {
        System.out.println("[Service] Lecture des qrcodes");
        return this.qrcodeRepository.findAll();
    }

    public void delete (int id) {
        System.out.println("[Service] Supression ancien qrcode");
        this.qrcodeRepository.deleteById(id);
    }

    public QRCode read(int id) {
        System.out.println("[Service] Lecture du qrcode");
        Optional<QRCode> optionalQRCode = this.qrcodeRepository.findById(id);
        return optionalQRCode.get();
    }
}
