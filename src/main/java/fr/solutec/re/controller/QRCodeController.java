package fr.solutec.re.controller;

import fr.solutec.re.entites.QRCode;
import fr.solutec.re.services.QRCodeService;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable int id) {
        System.out.println("[Controller] Supression ancien qrcode");
        this.qrcodeService.delete(id);
    }

    @GetMapping(path = "all")
    public @ResponseBody Iterable<QRCode> readAll() {
        System.out.println("[Controller] Lecture des qrcodes");
        return this.qrcodeService.readAll();
    }

    @GetMapping(path = "{id}")
    public @ResponseBody QRCode read(@PathVariable int id) {
        System.out.println("[Controller] Lecture du qrcode");
        QRCode qrcode = this.qrcodeService.read(id);
        return qrcode;
    }
}
