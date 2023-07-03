package br.com.webdinam.sistemaAvaliacao.model;


import javax.persistence.*;

@Entity
@Table(name = "questao")
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQuestao")
    private Integer idQuestao;

    @ManyToOne
    @JoinColumn(name = "prova_id")
    private Prova prova;

    @Column(name = "descricaoQuestao")
    private String descricaoQuestao;

    @Column(name = "alternativaA")
    private String alternativaA;

    @Column(name = "alternativaB")
    private String alternativaB;

    @Column(name = "alternativaC")
    private String alternativaC;

    @Column(name = "alternativaD")
    private String alternativaD;

    @Column(name = "alternativaE")
    private String alternativaE;

    @Column(name = "questaoCorreta")
    private String questaoCorreta;

    @Column(name = "estadoQuestao")
    private Integer estadoQuestao;

    @Column(name = "tipoQuestao_idTipoQuestao")
    private Integer tipoQuestao_idTipoQuestao;

    public Questao() {
    }

    public Questao(Integer idQuestao, String descricaoQuestao, String alternativaA, String alternativaB,
                   String alternativaC, String alternativaD, String alternativaE, String questaoCorreta,
                   Integer estadoQuestao, Integer tipoQuestao_idTipoQuestao) {
        this.idQuestao = idQuestao;
        this.descricaoQuestao = descricaoQuestao;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaD = alternativaD;
        this.alternativaE = alternativaE;
        this.questaoCorreta = questaoCorreta;
        this.estadoQuestao = estadoQuestao;
        this.tipoQuestao_idTipoQuestao = tipoQuestao_idTipoQuestao;
    }

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getDescricaoQuestao() {
        return descricaoQuestao;
    }

    public void setDescricaoQuestao(String descricaoQuestao) {
        this.descricaoQuestao = descricaoQuestao;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }

    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }

    public String getAlternativaD() {
        return alternativaD;
    }

    public void setAlternativaD(String alternativaD) {
        this.alternativaD = alternativaD;
    }

    public String getAlternativaE() {
        return alternativaE;
    }

    public void setAlternativaE(String alternativaE) {
        this.alternativaE = alternativaE;
    }

    public String getQuestaoCorreta() {
        return questaoCorreta;
    }

    public void setQuestaoCorreta(String questaoCorreta) {
        this.questaoCorreta = questaoCorreta;
    }

    public Integer getEstadoQuestao() {
        return estadoQuestao;
    }

    public void setEstadoQuestao(Integer estadoQuestao) {
        this.estadoQuestao = estadoQuestao;
    }

    public Integer getTipoQuestao_idTipoQuestao() {
        return tipoQuestao_idTipoQuestao;
    }

    public void setTipoQuestao_idTipoQuestao(Integer tipoQuestao_idTipoQuestao) {
        this.tipoQuestao_idTipoQuestao = tipoQuestao_idTipoQuestao;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public int getPontuacao(String respostaEscolhida){
            if (respostaEscolhida.equals(questaoCorreta)) {
                return 1; 
            } else {
                return 0; 
            }

    }


}
