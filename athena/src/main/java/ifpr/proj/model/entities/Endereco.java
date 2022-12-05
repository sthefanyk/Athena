package ifpr.proj.model.entities;

public class Endereco {
    
    private int enderecoID;
    private String cep;
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemeto;
    private Cidade cidade;
    
    public Endereco(int enderecoID, String cep, String logradouro, String bairro, String numero, String complemeto,
            Cidade cidade) {
        this.enderecoID = enderecoID;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.complemeto = complemeto;
        this.cidade = cidade;
    }
    
    public int getEnderecoID() {
        return enderecoID;
    }
    public void setEnderecoID(int enderecoID) {
        this.enderecoID = enderecoID;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getComplemeto() {
        return complemeto;
    }
    public void setComplemeto(String complemeto) {
        this.complemeto = complemeto;
    }
    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
