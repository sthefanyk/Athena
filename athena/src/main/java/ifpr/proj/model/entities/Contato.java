package ifpr.proj.model.entities;

public class Contato {
    private int contatoID;
    private Email email;
    private Telefone Telefone;
    
    public Contato(int contatoID, Email email, Telefone telefone) {
        this.contatoID = contatoID;
        this.email = email;
        Telefone = telefone;
    }
    public int getContatoID() {
        return contatoID;
    }
    public void setContatoID(int contatoID) {
        this.contatoID = contatoID;
    }
    public Email getEmail() {
        return email;
    }
    public void setEmail(Email email) {
        this.email = email;
    }
    public Telefone getTelefone() {
        return Telefone;
    }
    public void setTelefone(Telefone telefone) {
        Telefone = telefone;
    }
}
