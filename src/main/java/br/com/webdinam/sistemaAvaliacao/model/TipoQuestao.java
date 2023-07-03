package br.com.webdinam.sistemaAvaliacao.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipoQuestao")
public class TipoQuestao {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "tipoQuestao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Questao> questoes;

    public TipoQuestao() {
        this.questoes = new ArrayList<>();
    }

    public TipoQuestao(String descricao) {
        this.descricao = descricao;
        this.questoes = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public int obterQuantidadeQuestoes() {
        return questoes.size();
    }
    
}

