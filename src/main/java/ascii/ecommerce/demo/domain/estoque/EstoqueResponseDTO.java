package ascii.ecommerce.demo.domain.estoque;

import ascii.ecommerce.demo.domain.produto.ProdutoResponseDTO;

public record EstoqueResponseDTO(
        Integer quantidade,
        ProdutoResponseDTO produtoResponseDTO
) {
    public EstoqueResponseDTO(Estoque estoque){
        this(estoque.getQuantidade(), estoque.converteParaDto(estoque.getProduto()));
    }
}
