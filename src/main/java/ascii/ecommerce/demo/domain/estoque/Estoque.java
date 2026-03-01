package ascii.ecommerce.demo.domain.estoque;

import jakarta.persistence.*;

@Entity(name = "estoque")
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "estoque_seq", sequenceName = "estoque_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    @Column(name = "produtoId", nullable = false, unique = true)
    private Integer produtoId;

    public Estoque(){}
    public Estoque(Integer quantidade, Integer produtoId){
        this.quantidade = quantidade;
        this.produtoId = produtoId;
    }
    public Estoque(EstoqueRequestDTO estoqueRequestDTO){
        this.quantidade = estoqueRequestDTO.quantidade();
        this.produtoId = estoqueRequestDTO.produto_id();
    }


    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Integer getQuantidade() {return quantidade;}
    public void setQuantidade(Integer quantidade) {this.quantidade = quantidade;}

    public Integer getProdutoId() {return produtoId;}
    public void setProdutoId(Integer produtoId) {this.produtoId = produtoId;}
}
