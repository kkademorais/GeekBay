package ascii.ecommerce.demo.domain.produto;

import jakarta.persistence.*;

@Entity(name = "produto")
@Table(name = "produto")
public class Produto {

        // Consertar geração do ID


    @Id
        // Estudar SEQUENCE X IDENTITY
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "nome", nullable = false, unique = true) // Coloquei unique pra filtrar por nome corretamente
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco", nullable = false)
    private Double preco;
    @Column(name = "imagem")
    private String imagem;
    @Column(name = "categoria_id", nullable = false)
    private Integer categoria_id;                           // Adicionar esse como FK (Foreign Key)
    @Column(name = "ativo")
    private Boolean ativo;

    public Produto(){}

    public Produto(int id, String nome, String descricao, Double preco, String imagem, Integer categoria_id, Boolean ativo){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
        this.categoria_id = categoria_id;
        this.ativo = ativo;
    }

    public Produto(ProdutoRequestDTO produtoRequestDTO){
        this.nome = produtoRequestDTO.nome();
        this.descricao = produtoRequestDTO.descricao();
        this.preco = produtoRequestDTO.preco();
        this.imagem = produtoRequestDTO.imagem();
        this.categoria_id = produtoRequestDTO.categoria_id();
        this.ativo = produtoRequestDTO.ativo();
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public Double getPreco() {return preco;}
    public void setPreco(Double preco) {this.preco = preco;}

    public String getImagem() {return imagem;}
    public void setImagem(String imagem) {this.imagem = imagem;}

    public Integer getCategoria_id() {return categoria_id;}
    public void setCategoria_id(Integer categoria_id) {this.categoria_id = categoria_id;}

    public Boolean isAtivo() {return ativo;}
    public void setAtivo(Boolean ativo) {this.ativo = ativo;}

}
