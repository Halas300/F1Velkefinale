package PridaneVeci;

/**
 * Třída pro věci
 */
public class Veci {
    private String id;
    private String nazev;
    private String typ;
    private String popis;

    public String getId() {
        return id;
    }

    public String getNazev() {
        return nazev;
    }

    public Veci(String id, String nazev, String typ, String popis) {
        this.id = id;
        this.nazev = nazev;
        this.typ = typ;
        this.popis = popis;
    }

    public String getTyp() {
        return typ;
    }

    public String getPopis() {
        return popis;
    }

}
