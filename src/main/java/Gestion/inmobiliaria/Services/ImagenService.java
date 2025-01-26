package Gestion.inmobiliaria.Services;

import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.ImagenDTO;
import Gestion.inmobiliaria.Persistance.entities.Contract;
import Gestion.inmobiliaria.Persistance.entities.Imagen;
import Gestion.inmobiliaria.Persistance.entities.Payment;
import Gestion.inmobiliaria.Persistance.repository.ContractRepository;
import Gestion.inmobiliaria.Persistance.repository.ImagenRepository;
import Gestion.inmobiliaria.Persistance.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ContractRepository contractRepository;

    // Asociar imagen a un Payment
    public void addImageToPayment(Long paymentId, ImagenDTO imagenDTO) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(() -> new RuntimeException("Payment not found"));

        Imagen imagen = new Imagen();
        imagen.setDatos(imagenDTO.getDatos());
        imagen.setTipo(imagenDTO.getTipo());
        imagen.setTamaño(imagenDTO.getTamaño());
        imagen.setEvent(payment); // Asociamos la imagen con el pago

        imagenRepository.save(imagen);
    }

    // Asociar imagen a un Contract
    public void addImageToContract(Long contractId, ImagenDTO imagenDTO) {
        Contract contract = contractRepository.findById(contractId).orElseThrow(() -> new RuntimeException("Contract not found"));

        Imagen imagen = new Imagen();
        imagen.setDatos(imagenDTO.getDatos());
        imagen.setTipo(imagenDTO.getTipo());
        imagen.setTamaño(imagenDTO.getTamaño());
        imagen.setEvent(contract); // Asociamos la imagen con el contrato

        imagenRepository.save(imagen);
    }
}
