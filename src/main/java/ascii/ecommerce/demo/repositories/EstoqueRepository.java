package ascii.ecommerce.demo.repositories;

import ascii.ecommerce.demo.domain.estoque.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
    Estoque findByProdutoId(Integer id);
}
