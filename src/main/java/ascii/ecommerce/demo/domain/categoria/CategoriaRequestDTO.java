package ascii.ecommerce.demo.domain.categoria;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequestDTO(
        @NotBlank
        String nome,
        String descricao
) {}
