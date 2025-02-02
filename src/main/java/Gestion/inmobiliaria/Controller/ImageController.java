package Gestion.inmobiliaria.Controller;

import Gestion.inmobiliaria.Services.ImagenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImagenService imagenService;

    // Agregar imagen a un Payment
    @PostMapping("/payment/{paymentId}")
    public ResponseEntity<String> addImageToPayment(@PathVariable Long paymentId,
                                                    @RequestParam("file") MultipartFile file) {
        try {
            imagenService.addImageToPayment(paymentId, file);
            return ResponseEntity.ok("Imagen agregada al pago con éxito");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al agregar la imagen al pago");
        }
    }

    // Agregar imagen a un Contract
    @PostMapping("/contract/{contractId}")
    public ResponseEntity<String> addImageToContract(@PathVariable Long contractId,
                                                     @RequestParam("file") MultipartFile file) {
        try {
            imagenService.addImageToContract(contractId, file);
            return ResponseEntity.ok("Imagen agregada al contrato con éxito");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al agregar la imagen al contrato");
        }
    }
}
