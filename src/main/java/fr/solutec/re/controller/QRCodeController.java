package fr.solutec.re.controller;

import fr.solutec.re.entites.QRCode;
import fr.solutec.re.services.QRCodeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
@RestController
@RequestMapping(path = "qrcode", produces = APPLICATION_JSON_VALUE)
public class QRCodeController {
    private QRCodeService qrcodeService;
    public QRCodeController(QRCodeService qrcodeService) {
        this.qrcodeService = qrcodeService;
    }

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody QRCode qrcode) {
        System.out.println("[Controller] Creation nouveau qrcode");
        this.qrcodeService.create(qrcode);
    }

    @RequestMapping(method = DELETE, consumes = APPLICATION_JSON_VALUE)
    public void delete(@RequestBody QRCode qrcode) {
        System.out.println("[Controller] Supression ancien qrcode");
        this.qrcodeService.delete(qrcode);
    }

    @RequestMapping(method = GET)
    public @ResponseBody Set<QRCode> readAll() {
        System.out.println("Lecture des qrcodes");
        return this.qrcodeService.readAll();
    }
}
