package br.com.zup.LeadCollector.Lead;

import br.com.zup.LeadCollector.Produto.Produto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "leads")
public class Lead {
    @Id
    private String email;
    @Column(columnDefinition = "VARCHAR(100) DEFAULT 'NAO INFORMADO'")
    private String nome;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Produto> produtosDesejados;

    public Lead(String email, String nome, List<Produto> produtosDesejados) {
        this.email = email;
        this.nome = nome;
        this.produtosDesejados = produtosDesejados;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutosDesejados() {
        return produtosDesejados;
    }

    public void setProdutosDesejados(List<Produto> produtosDesejados) {
        this.produtosDesejados = produtosDesejados;
    }

}
