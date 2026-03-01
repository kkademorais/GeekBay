package ascii.ecommerce.demo.controllers;

import ascii.ecommerce.demo.domain.endereco.EnderecoResponseDTO;
import ascii.ecommerce.demo.services.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<Object> getEnderecoByCep(@PathVariable String cep){
        return ResponseEntity.ok(this.enderecoService.getEnderecoByCep(cep));
    }

}
