package ifpr.proj.model.entities;

public enum Sexo {
    FEMININO(0, "Feminino"),
    MASCULINO(1, "Masculino");

    private int id;
    private String sexo;

    Sexo(int id, String sexo){
        this.id = id;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public String getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return this.sexo;
    }
}
