package ifpr.proj.model.entities;

public enum CorRaca {

    BRANCO(0, "Branco"),
    PARDO(1, "Pardo"),
    PRETO(2, "Preto"),
    INDIGENA(4, "Indigena");

    private int id;
    private String corRaca;

    CorRaca(int id, String corRaca){
        this.id = id;
        this.corRaca = corRaca;
    }

    public int getId() {
        return id;
    }

    public String getCorRaca() {
        return corRaca;
    }

    @Override
    public String toString() {
        return this.corRaca;
    }

}
