package ascii.ecommerce.demo.domain.produto;


public record ProdutoPatchRequestDTO(
        String nome,
        String descricao,
        Double preco,
        String imagem,
        Integer categoria_id,
        Boolean ativo
) {}
