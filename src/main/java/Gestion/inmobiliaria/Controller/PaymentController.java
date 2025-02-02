package Gestion.inmobiliaria.Controller;

import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.PaymentDTO;
import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.PaymentForResponse;
import Gestion.inmobiliaria.Persistance.entities.Payment;

import Gestion.inmobiliaria.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody PaymentDTO paymentDTO) {
        try {
            PaymentForResponse createdPayment = paymentService.createPayment(paymentDTO);



            return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentForResponse> getPaymentById(@PathVariable Long id) {
        try {
            PaymentForResponse payment = paymentService.getPaymentById(id);
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
