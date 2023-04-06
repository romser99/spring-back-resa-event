package fr.solutec.resaevent.services;

import com.google.zxing.WriterException;
import fr.solutec.resaevent.entites.Reservation;
import fr.solutec.resaevent.utils.EmailSenderService;
import fr.solutec.resaevent.utils.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
@Service
public class QRCodeService {

    @Autowired
    private EmailSenderService emailSenderService;
    public void createQRC(Reservation reservation) throws IOException, WriterException, MessagingException {
        String unom = reservation.getClient().getNom();
        QRCodeGenerator.generateQRCode(reservation);
        String IdAsString = String.valueOf(reservation.getId());
        /*Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String currentMail = ((UserDetails)principal).getUsername();*/
        emailSenderService.sendMailWithAttachments(
                //adresse mail à remplacer apar current mail une fois la sécu implémentée
                ""+reservation.getClient().getEmail()+"",
                "Invitation à un Event Exceptionnel" + "\n"
                        + "Bonjour" + reservation.getClient().getNom() + "\n"
                        + "Voici votre QRCode pour l'évenement" + reservation.getEvenement().getNom() + "\n",
                "Votre Réservation Eventiva",
                "C:\\Users\\dsi\\Documents\\resa-event\\spring-back-resa-event\\src\\main\\resources\\QRC\\" + IdAsString + "-QRCODE.png");
    }
}
