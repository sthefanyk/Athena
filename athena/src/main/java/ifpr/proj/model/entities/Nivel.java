package ifpr.proj.model.entities;

public enum Nivel {
    ADMIN(0, "Admin"),
    ALUNO(1, "Aluno"),
    PROFESSOR(0, "Professor"),
    COORDENACAO(1, "Coordenacao");

    private int id;
    private String tipo;

    private Nivel(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
