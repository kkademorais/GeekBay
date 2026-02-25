package ascii.ecommerce.demo.services;

import ascii.ecommerce.demo.domain.produto.Produto;
import ascii.ecommerce.demo.domain.produto.ProdutoPatchRequestDTO;
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
            if(produtoRequestDTO.nome() == null) produtoUpdate.setNome(this.produtoRepository.findById(id).get().getNome());
            if(produtoRequestDTO.descricao() == null) produtoUpdate.setDescricao(this.produtoRepository.findById(id).get().getDescricao());
            if(produtoRequestDTO.preco() == null) produtoUpdate.setPreco(this.produtoRepository.findById(id).get().getPreco());
            if(produtoRequestDTO.categoria_id() == null) produtoUpdate.setCategoria_id(this.produtoRepository.findById(id).get().getCategoria_id());
            if(produtoRequestDTO.ativo() == null) produtoUpdate.setAtivo(this.produtoRepository.findById(id).get().isAtivo());
            this.produtoRepository.save(produtoUpdate);
        }
        // Retornar 400 se não existir
        // Corrigir pois pode dar update só de um atributo, criando assim um produto com atributos vazios
    }

    public void updateProdutoByNome(String nome, ProdutoRequestDTO produtoRequestDTO){
        if(this.produtoRepository.findByNome(nome) != null){
            Produto produtoUpdate = new Produto(produtoRequestDTO);
            produtoUpdate.setId(this.produtoRepository.findAll().stream().filter(produto -> produto.getNome().equalsIgnoreCase(nome)).findFirst().get().getId());
            if(produtoRequestDTO.nome() == null) produtoUpdate.setNome(this.produtoRepository.findByNome(nome).getNome());
            if(produtoRequestDTO.descricao() == null) produtoUpdate.setDescricao(this.produtoRepository.findByNome(nome).getDescricao());
            if(produtoRequestDTO.preco() == null) produtoUpdate.setPreco(this.produtoRepository.findByNome(nome).getPreco());
            if(produtoRequestDTO.categoria_id() == null) produtoUpdate.setCategoria_id(this.produtoRepository.findByNome(nome).getCategoria_id());
            if(produtoRequestDTO.ativo() == null) produtoUpdate.setAtivo(this.produtoRepository.findByNome(nome).isAtivo());
            this.produtoRepository.save(produtoUpdate);
        }
    }


        // PATCH -> Update parcial
    public void updatePartialProdutoById(int id, ProdutoPatchRequestDTO produtoPatchRequestDTO){
        //Inserir Try-Catch
        Produto produtoBuscado = this.produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não cadastrado"));
        if(produtoPatchRequestDTO.nome() != null) produtoBuscado.setNome(produtoPatchRequestDTO.nome());
        if(produtoPatchRequestDTO.descricao() != null) produtoBuscado.setDescricao(produtoPatchRequestDTO.descricao());
        if(produtoPatchRequestDTO.preco() != null) produtoBuscado.setPreco(produtoPatchRequestDTO.preco());
        if(produtoPatchRequestDTO.imagem() != null) produtoBuscado.setImagem(produtoBuscado.getImagem());
        if(produtoPatchRequestDTO.categoria_id() != null) produtoBuscado.setCategoria_id(produtoBuscado.getCategoria_id());
        if(produtoPatchRequestDTO.ativo() != null) produtoBuscado.setAtivo(produtoBuscado.isAtivo());
        
    }

        // DELETE

    public void deleteProdutoById(int id){
        this.produtoRepository.deleteById(id);
    }
}
