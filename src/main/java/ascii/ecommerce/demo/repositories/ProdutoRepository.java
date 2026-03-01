package ascii.ecommerce.demo.repositories;


import ascii.ecommerce.demo.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
        // Case sensitive -> Necessário consertar
    Produto findByNome(String nome);
    List<Produto> findByCategoriaId(Integer categoriaId);
}
