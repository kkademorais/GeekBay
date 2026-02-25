package ascii.ecommerce.demo.domain.produto;

import jakarta.persistence.Column;

public record ProdutoResponseDTO(
        int id,
        String nome,
        String descricao,
        Double preco,
        String imagem,
        int categoria_id,
        boolean ativo
){
    public ProdutoResponseDTO(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getImagem(), produto.getCategoria_id(), produto.isAtivo());
    }
}
