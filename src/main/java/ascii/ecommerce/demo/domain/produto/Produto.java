package ascii.ecommerce.demo.domain.produto;

import jakarta.persistence.*;

@Entity(name = "produto")
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco", nullable = false)
    private Double preco;
    @Column(name = "imagem")
    private String imagem;
    @Column(name = "categoria_id", nullable = false)
    private Integer categoria_id;
    @Column(name = "ativo")
    private Boolean ativo;

    public Produto(){}

    public Produto(int id, String nome, String descricao, Double preco, String imagem, int categoria_id, boolean ativo){
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

    public Produto(ProdutoPatchRequestDTO produtoPatchRequestDTO){
        this.nome = produtoPatchRequestDTO.nome();
        this.descricao = produtoPatchRequestDTO.descricao();
        this.preco = produtoPatchRequestDTO.preco();
        this.imagem = produtoPatchRequestDTO.imagem();
        this.categoria_id = produtoPatchRequestDTO.categoria_id();
        this.ativo = produtoPatchRequestDTO.ativo();
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

    public int getCategoria_id() {return categoria_id;}
    public void setCategoria_id(int categoria_id) {this.categoria_id = categoria_id;}

    public boolean isAtivo() {return ativo;}
    public void setAtivo(boolean ativo) {this.ativo = ativo;}

}
