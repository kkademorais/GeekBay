package ascii.ecommerce.demo.services;

import ascii.ecommerce.demo.domain.estoque.Estoque;
import ascii.ecommerce.demo.domain.estoque.EstoqueRequestDTO;
import ascii.ecommerce.demo.domain.estoque.EstoqueResponseDTO;
import ascii.ecommerce.demo.domain.produto.Produto;
import ascii.ecommerce.demo.repositories.EstoqueRepository;
import ascii.ecommerce.demo.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;
    private final ProdutoRepository produtoRepository;

    public EstoqueService(EstoqueRepository estoqueRepository, ProdutoRepository produtoRepository){
        this.estoqueRepository = estoqueRepository;
        this.produtoRepository = produtoRepository;
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
        Produto produtoAdd = this.produtoRepository.findById(estoqueRequestDTO.produto_id()).get();
        Estoque estoqueAdd = new Estoque();
        estoqueAdd.setQuantidade(estoqueRequestDTO.quantidade());
        estoqueAdd.setProduto(produtoAdd);
        this.estoqueRepository.save(estoqueAdd);
    }

            // PUT
    public void updateQuantidadeByProdutoId(Integer id, EstoqueRequestDTO estoqueRequestDTO){
        Estoque estoqueASerBuscado = this.estoqueRepository.findByProdutoId(id);
        if(estoqueASerBuscado != null){
            estoqueASerBuscado.setQuantidade(estoqueRequestDTO.quantidade());
            estoqueASerBuscado.setProduto(this.produtoRepository.findById(id).get());
            this.estoqueRepository.save(estoqueASerBuscado);
        }
        else throw new RuntimeException("ID inválido ou produto inexistente");;
    }

}
