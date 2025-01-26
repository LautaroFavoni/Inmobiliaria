package Gestion.inmobiliaria.Controller;
import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.ContractDTO;
import Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs.ContractForResponse;
import Gestion.inmobiliaria.Persistance.entities.Contract;
import Gestion.inmobiliaria.Services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping("/create")
    public ResponseEntity<ContractForResponse> createContract(@RequestBody ContractDTO contractDTO) {
        try {
            ContractForResponse createdContract = contractService.createContract(contractDTO);
            return new ResponseEntity<>(createdContract, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
