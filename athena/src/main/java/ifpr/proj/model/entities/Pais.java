package ifpr.proj.model.entities;

public class Pais {
    
    private int paisID;
    private String pais;
    
    public Pais(int paisID, String pais) {
        this.paisID = paisID;
        this.pais = pais;
    }
    public int getPaisID() {
        return paisID;
    }
    public void setPaisID(int paisID) {
        this.paisID = paisID;
    }
    public String getNome() {
        return pais;
    }
    public void setNome(String pais) {
        this.pais = pais;
    }
}
