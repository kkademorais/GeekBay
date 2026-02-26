package ascii.ecommerce.demo.repositories;


import ascii.ecommerce.demo.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
        // Case sensitive -> Necessário consertar
    Produto findByNome(String nome);
}
