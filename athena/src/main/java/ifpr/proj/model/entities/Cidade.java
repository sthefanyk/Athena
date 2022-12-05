package ifpr.proj.model.entities;

public class Cidade {

    private int cidadeID;
    private String cidade;
    private Estado estado;

    public Cidade(String cidade) {
        this.cidade = cidade;
    }
    
    public Cidade(int cidadeID, String cidade, Estado estado) {
        this.cidadeID = cidadeID;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getCidadeID() {
        return cidadeID;
    }
    public void setCidadeID(int cidadeID) {
        this.cidadeID = cidadeID;
    }
    public String getNome() {
        return cidade;
    }
    public void setNome(String cidade) {
        this.cidade = cidade;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return this.cidade;
    }

}
