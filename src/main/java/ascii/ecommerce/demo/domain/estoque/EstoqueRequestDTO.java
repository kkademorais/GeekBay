package ascii.ecommerce.demo.domain.estoque;

public record EstoqueRequestDTO(
        Integer quantidade,
        Integer produto_id
) {}
