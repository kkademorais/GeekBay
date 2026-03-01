package ascii.ecommerce.demo.services;

import ascii.ecommerce.demo.domain.endereco.Endereco;
import ascii.ecommerce.demo.domain.endereco.EnderecoResponseDTO;
import ascii.ecommerce.demo.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {




    public Object getEnderecoByCep(String cep){
        String url = "https://brasilapi.com.br/api/cep/v1/" + cep;

        RestTemplate restTemplate = new RestTemplate();
        //Object endereco = restTemplate.getForObject(url, Object.class);

        return restTemplate.getForObject(url, Object.class);
    }



}
