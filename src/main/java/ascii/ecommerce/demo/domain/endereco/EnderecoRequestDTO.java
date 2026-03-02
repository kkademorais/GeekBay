package ascii.ecommerce.demo.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoRequestDTO(
        @NotBlank
        String cep,
        @NotNull
        Integer usuarioId
) {
}
