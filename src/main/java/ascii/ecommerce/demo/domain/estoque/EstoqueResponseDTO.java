package ascii.ecommerce.demo.domain.estoque;

public record EstoqueResponseDTO(
        Integer quantidade,
        Integer produto_id
) {
    public EstoqueResponseDTO(Estoque estoque){
        this(estoque.getQuantidade(), estoque.getProdutoId());
    }
}
