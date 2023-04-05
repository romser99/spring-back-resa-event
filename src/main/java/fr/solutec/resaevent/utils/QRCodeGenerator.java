package fr.solutec.resaevent.utils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import fr.solutec.resaevent.entites.Reservation;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
    public static void generateQRCode(Reservation reservation) throws WriterException, IOException {
        // Chemin d'accès de l'emplacement où sont stockés les QRCODES.png générés
        String IdAsString = String.valueOf(reservation.getId());
        String qrCodePath ="classpath**:\\src\\main\\resources\\QRC\\";
        // Nom que portera le fichier .png du QRCode
        String qrCodeName = qrCodePath+IdAsString+"-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();
        // Informations qui apparaitront lorsque le QRCode sera scanné :
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "Nom évenement: "+reservation.getEvenement().getNom()+ "\n"+
                        "Date début"+reservation.getAgenda().getDateDebut()+ "\n"+
                        "Date fin"+reservation.getAgenda().getDateFin()+ "\n"+
                        "Salle"+reservation.getPlace().getSalle()+ "\n"+
                        "Place"+reservation.getPlace().getCategorie()+ "\n",
                BarcodeFormat.QR_CODE, 300, 300);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
