package ascii.ecommerce.demo.domain.produto;

public record ProdutoRequestDTO(
        String nome,
        String descricao,
        Double preco,
        String imagem,
        int categoria_id,
        boolean ativo
) {}
