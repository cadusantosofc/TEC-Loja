package br.com.tecloja.api.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 500)
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false)
    private int estoque;

    // 1. ADICIONADO: Atributo para o Soft Delete (mapeado no banco de dados)
    @Column(nullable = false)
    private boolean ativo = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    public Produto() {}

    // Getters, Setters e Construtores
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
    public int getEstoque() { return estoque; }
    public void setEstoque(int estoque) { this.estoque = estoque; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    // 2. ADICIONADO: Getter para o atributo boolean (convenção do Java usa "is" em vez de "get")
    public boolean isAtivo() { 
        return ativo; 
    }

    // 3. ADICIONADO: Setter para alterar o status do produto
    public void setAtivo(boolean ativo) { 
        this.ativo = ativo; 
    }
}