package Gestion.inmobiliaria.Controller;
import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.ContractDTO;
import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.ContractForResponse;
import Gestion.inmobiliaria.Persistance.entities.Contract;
import Gestion.inmobiliaria.Services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping("/create")
    public ResponseEntity<?> createContract(@RequestBody ContractDTO contractDTO) {
        try {
            System.out.println("Contract DTO received: " + contractDTO);
            ContractForResponse createdContract = contractService.createContract(contractDTO);
            return new ResponseEntity<>(createdContract, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }



    @GetMapping("/all")
    public ResponseEntity<List<ContractForResponse>> getAllContracts() {
        try {
            List<ContractForResponse> contracts = contractService.getAllContracts();
            return new ResponseEntity<>(contracts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
