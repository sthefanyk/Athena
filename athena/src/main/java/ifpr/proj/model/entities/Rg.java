package ifpr.proj.model.entities;

import java.time.LocalDate;

public class Rg {
    private int rgID;
    private String rg;
    private String nome;
    private LocalDate dataExpedicao;
    private String orgaoExpedidor;
    private String nomeMae;
    private String nomePai;
    private Cidade naturalidade;
    private Estado uf;
    
    public Rg(int rgID, String rg, String nome, LocalDate dataExpedicao, String orgaoExpedidor, String nomeMae,
            String nomePai, Cidade naturalidade, Estado uf) {
        this.rgID = rgID;
        this.rg = rg;
        this.nome = nome;
        this.dataExpedicao = dataExpedicao;
        this.orgaoExpedidor = orgaoExpedidor;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.naturalidade = naturalidade;
        this.uf = uf;
    }
    public Rg(String rg, String nome, LocalDate dataExpedicao, String orgaoExpedidor, String nomeMae,
            String nomePai, Cidade naturalidade, Estado uf) {
        this.rgID = rgID;
        this.rg = rg;
        this.nome = nome;
        this.dataExpedicao = dataExpedicao;
        this.orgaoExpedidor = orgaoExpedidor;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.naturalidade = naturalidade;
        this.uf = uf;
    }
    public void setRgID(int rgID) {
        this.rgID = rgID;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getDataExpedicao() {
        return dataExpedicao;
    }
    public void setDataExpedicao(LocalDate dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }
    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }
    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }
    public String getNomeMae() {
        return nomeMae;
    }
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }
    public String getNomePai() {
        return nomePai;
    }
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }
    public Cidade getNaturalidade() {
        return naturalidade;
    }
    public void setNaturalidade(Cidade naturalidade) {
        this.naturalidade = naturalidade;
    }
    public Estado getUf() {
        return uf;
    }
    public int getRgID() {
        return rgID;
    }
    public void setUf(Estado uf) {
        this.uf = uf;
    }
    
    




}
