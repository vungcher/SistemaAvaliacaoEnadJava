package br.com.webdinam.sistemaAvaliacao.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name = "prova")
public class Prova {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProva")
    private int idProva;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "prova", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Questao> questoes;

    public Prova() {
        this.questoes = new ArrayList<>();
    }


    public Prova(int idProva, String nome) {
        this.idProva = idProva;
        this.nome = nome;
        this.questoes = new ArrayList<>();
    }

    public int getIdProva() {
        return idProva;
    }

    public void setIdProva(int idProva) {
        this.idProva = idProva;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public void adicionarQuestao(Questao questao) {
        questoes.add(questao);
        questao.setProva(this);
    }

    public void removerQuestao(Questao questao) {
        questoes.remove(questao);
        questao.setProva(null);
    }

    public int calcularPontuacaoTotal(Prova prova, List<String> respostasEscolhidas) {
        int pontuacaoTotal = 0;
        List<Questao> questoes = prova.getQuestoes();

        for (int i = 0; i < questoes.size(); i++) {
            Questao questao = questoes.get(i);
            String respostaEscolhida = respostasEscolhidas.get(i);

            pontuacaoTotal += questao.getPontuacao(respostaEscolhida);
        }

        return pontuacaoTotal;
    }

    public int getNumeroQuestao(){
        return questoes.size();
    }

}
