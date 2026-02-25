package ascii.ecommerce.demo.services;

import ascii.ecommerce.demo.domain.produto.Produto;
import ascii.ecommerce.demo.domain.produto.ProdutoRequestDTO;
import ascii.ecommerce.demo.domain.produto.ProdutoResponseDTO;
import ascii.ecommerce.demo.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }


        // GET

    public List<ProdutoResponseDTO> getProdutoList(){
        return this.produtoRepository
                    .findAll()
                    .stream()
                    .map(p -> new ProdutoResponseDTO(p))
                    .toList();
    }

    public ProdutoResponseDTO getProdutoById(int id){
        return this.produtoRepository
                .findById(id)
                .map(produto -> new ProdutoResponseDTO(produto))
                .get();
    }

    public ProdutoResponseDTO getProdutoByNome(String nome){
        return this.produtoRepository
                .findAll()
                .stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .map(produto -> new ProdutoResponseDTO(produto))
                .get();
    }

    public List<ProdutoResponseDTO> getProdutoListByCategoria(int categoria_id){
        return this.produtoRepository
                .findAll()
                .stream()
                .filter(produto -> produto.getCategoria_id() == categoria_id)
                .map(produto -> new ProdutoResponseDTO(produto))
                .toList();
    }


        // POST

    public void addNewProduto(ProdutoRequestDTO produtoRequestDTO){
        this.produtoRepository.save(new Produto(produtoRequestDTO));
    }


        // PUT

    public void updateProdutoById(int id, ProdutoRequestDTO produtoRequestDTO){
        if(this.produtoRepository.existsById(id)){
            Produto produtoUpdate = new Produto(produtoRequestDTO);
            produtoUpdate.setId(id);
            this.produtoRepository.save(produtoUpdate);
        }
        // Retornar 400 se não existir
        // Corrigir pois pode dar update só de um atributo, criando assim um produto com atributos vazios
    }


        // DELETE

    public void deleteProdutoById(int id){
        this.produtoRepository.deleteById(id);
    }
}
