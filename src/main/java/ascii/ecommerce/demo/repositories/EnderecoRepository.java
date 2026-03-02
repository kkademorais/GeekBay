package ascii.ecommerce.demo.repositories;

import ascii.ecommerce.demo.domain.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    Endereco findByUsuarioId(Integer usuarioId);
    Endereco findByCep(String cep);
}
