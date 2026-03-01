package ascii.ecommerce.demo.services;

import ascii.ecommerce.demo.domain.estoque.Estoque;
import ascii.ecommerce.demo.domain.estoque.EstoqueRequestDTO;
import ascii.ecommerce.demo.domain.estoque.EstoqueResponseDTO;
import ascii.ecommerce.demo.repositories.EstoqueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    public EstoqueService(EstoqueRepository estoqueRepository){
        this.estoqueRepository = estoqueRepository;
    }

            // GET
    public List<EstoqueResponseDTO> getEstoqueList(){
        return this.estoqueRepository.findAll().stream().map(estoque -> new EstoqueResponseDTO(estoque)).toList();
    }
    public EstoqueResponseDTO getEstoqueByProdutoId(Integer id){
        Estoque produtoASerBuscadoNoEstoque = this.estoqueRepository.findByProdutoId(id);
        if(produtoASerBuscadoNoEstoque != null){
            return new EstoqueResponseDTO(produtoASerBuscadoNoEstoque);
        }
        else throw new RuntimeException("Id inválido ou produto inexistente");
    }

            // POST
    public void addNewProdutoInEstoque(EstoqueRequestDTO estoqueRequestDTO){
        this.estoqueRepository.save(new Estoque(estoqueRequestDTO));
    }

            // PUT
    public void updateQuantidadeByProdutoId(Integer id, EstoqueRequestDTO estoqueRequestDTO){
        Estoque estoqueASerBuscado = this.estoqueRepository.findByProdutoId(id);
        if(estoqueASerBuscado != null){
            estoqueASerBuscado.setQuantidade(estoqueRequestDTO.quantidade());
            estoqueASerBuscado.setProdutoId(estoqueRequestDTO.produto_id());
            this.estoqueRepository.save(estoqueASerBuscado);
        }
        else throw new RuntimeException("ID inválido ou produto inexistente");;
    }

}
