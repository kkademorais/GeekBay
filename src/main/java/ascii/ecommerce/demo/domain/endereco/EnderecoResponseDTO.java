package ascii.ecommerce.demo.domain.endereco;

public record EnderecoResponseDTO(
    String cep,
    String state,
    String city,
    String neighborhood,
    String street,
    String service
) {
    public EnderecoResponseDTO(Endereco endereco){
        this(endereco.getCep(), endereco.getState(), endereco.getCity(), endereco.getNeighborhood(), endereco.getStreet(), endereco.getService());
    }
}
