package ascii.ecommerce.demo.domain.inventario;

import jakarta.persistence.*;

@Entity(name = "inventario")
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "inventario_seq", sequenceName = "inventario_seq", allocationSize = 1)
    private int id;
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "produto_id")
    private int produto_id;


    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getQuantidade() {return quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

    public int getProduto_id() {return produto_id;}
    public void setProduto_id(int produto_id) {this.produto_id = produto_id;}
}
