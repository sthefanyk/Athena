package ifpr.proj.model.entities;

public class Telefone {
    
    private int telefoneID;
    private String telefone;
    
    public Telefone() {
    }
    public Telefone(int telefoneID, String telefone) {
        this.telefoneID = telefoneID;
        this.telefone = telefone;
    }
    public int getTelefoneID() {
        return telefoneID;
    }
    public void setTelefoneID(int telefoneID) {
        this.telefoneID = telefoneID;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
