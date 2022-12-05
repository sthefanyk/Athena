package ifpr.proj.model.entities;

public class Usuario {
    private int pessoaID; 
    private String login;
    private String senha;
    private Nivel nivel;
    public Usuario(String login, String senha, Nivel nivel) {
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
    }
    public Usuario(int pessoaID, String login, String senha, Nivel nivel) {
        this.pessoaID = pessoaID;
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
    }
    public int getPessoaID() {
        return pessoaID;
    }
    public void setPessoaID(int pessoaID) {
        this.pessoaID = pessoaID;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Nivel getNivel() {
        return nivel;
    }
    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

}
