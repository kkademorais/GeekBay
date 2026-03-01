package ascii.ecommerce.demo.domain.produto;

import ascii.ecommerce.demo.domain.categoria.Categoria;
import ascii.ecommerce.demo.domain.categoria.CategoriaResponseDTO;

public record ProdutoResponseDTO(
        int id,
        String nome,
        String descricao,
        Double preco,
        String imagem,
        //Categoria categoria,
        CategoriaResponseDTO categoriaResponseDTO,
        Boolean ativo
){
    public ProdutoResponseDTO(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getImagem(), produto.converteParaDto(produto.getCategoria()), produto.isAtivo());
    }
}
