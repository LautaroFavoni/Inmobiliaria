package Gestion.inmobiliaria.Controller;

import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.ImagenDTO;
import Gestion.inmobiliaria.Services.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImagenService imagenService;

    // Agregar imagen a un Payment
    @PostMapping("/payment/{paymentId}")
    public void addImageToPayment(@PathVariable Long paymentId, @RequestBody ImagenDTO imagenDTO) {
        imagenService.addImageToPayment(paymentId, imagenDTO);
    }

    // Agregar imagen a un Contract
    @PostMapping("/contract/{contractId}")
    public void addImageToContract(@PathVariable Long contractId, @RequestBody ImagenDTO imagenDTO) {
        imagenService.addImageToContract(contractId, imagenDTO);
    }
}
