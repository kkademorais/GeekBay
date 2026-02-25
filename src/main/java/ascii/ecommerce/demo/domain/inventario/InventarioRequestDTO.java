package ascii.ecommerce.demo.domain.inventario;

public record InventarioRequestDTO(
        int quantidade,
        int produto_id
) {}
