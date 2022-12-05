package ifpr.proj.model.entities;

public class Estado {
    
    private int estadoID;
    private String estado;
    private Pais pais;

    public Estado(String estado) {
        this.estado = estado;
    }
    
    public Estado(int estadoID, String estado, Pais pais) {
        this.estadoID = estadoID;
        this.estado = estado;
        this.pais = pais;
    }
    
    public int getEstadoID() {
        return estadoID;
    }
    public void setEstadoID(int estadoID) {
        this.estadoID = estadoID;
    }
    public String getNome() {
        return estado;
    }
    public void setNome(String estado) {
        this.estado = estado;
    }
    public Pais getPais() {
        return pais;
    }
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return this.estado;
    }
    

    
}
