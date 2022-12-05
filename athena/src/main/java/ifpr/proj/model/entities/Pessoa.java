package ifpr.proj.model.entities;

public class Pessoa {

    private int pessoaID;
    private String cpf;
    private String primeiroNome;
    private String ultimoNome;
    private Sexo sexo;
    private CorRaca corRaca;
    private boolean possuiNecessidadesEspecificas;
    private Rg rg;
    private Contato contato;
    private Endereco endereco;

    public Pessoa(){        
    }
    
    public Pessoa(String cpf, String primeiroNome, String ultimoNome, Sexo sexo, CorRaca corRaca,
            boolean possuiNecessidadesEspecificas, Rg rg, Contato contato, Endereco endereco) {
        this.cpf = cpf;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.sexo = sexo;
        this.corRaca = corRaca;
        this.possuiNecessidadesEspecificas = possuiNecessidadesEspecificas;
        this.rg = rg;
        this.contato = contato;
        this.endereco = endereco;
    }
    public Pessoa(int pessoaID, String cpf, String primeiroNome, String ultimoNome, Sexo sexo, CorRaca corRaca,
            boolean possuiNecessidadesEspecificas, Rg rg, Contato contato, Endereco endereco) {
        this.pessoaID = pessoaID;
        this.cpf = cpf;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.sexo = sexo;
        this.corRaca = corRaca;
        this.possuiNecessidadesEspecificas = possuiNecessidadesEspecificas;
        this.rg = rg;
        this.contato = contato;
        this.endereco = endereco;
    }
    public String getPrimeiroNome() {
        return primeiroNome;
    }
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }
    public String getUltimoNome() {
        return ultimoNome;
    }
    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }
    public Sexo getSexo() {
        return sexo;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    public CorRaca getCorRaca() {
        return corRaca;
    }
    public void setCorRaca(CorRaca corRaca) {
        this.corRaca = corRaca;
    }
    public boolean isPossuiNecessidadesEspecificas() {
        return possuiNecessidadesEspecificas;
    }
    public void setPossuiNecessidadesEspecificas(boolean possuiNecessidadesEspecificas) {
        this.possuiNecessidadesEspecificas = possuiNecessidadesEspecificas;
    }

    public Contato getContato() {
        return contato;
    }

    public int getContatoID() {
        return contato.getContatoID();
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    public Endereco getEndereco() {
        return endereco;
    }

    public int getEnderecoID() {
        return endereco.getEnderecoID();
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getPessoaID() {
        return pessoaID;
    }

    public void setPessoaID(int pessoaID) {
        this.pessoaID = pessoaID;
    }
    public Rg getRg() {
        return rg;
    }
    public int getRgID() {
        return rg.getRgID();
    }
    public void setRg(Rg rg) {
        this.rg = rg;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}