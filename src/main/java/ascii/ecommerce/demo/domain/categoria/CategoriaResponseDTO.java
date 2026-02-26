package ascii.ecommerce.demo.domain.categoria;

public record CategoriaResponseDTO(
        Integer id,
        String nome,
        String descricao
) {
    public CategoriaResponseDTO(Categoria categoria){
        this(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }
}
