package PridaneVeci;
import java.util.ArrayList;

/**
 * Třída pro místnosti
 */
public class Mistnosti {
    private String id;
    private String nazev;
    private String popis;
    public ArrayList<String> soused;
    public ArrayList<String> veciVMistnosti;

    public String getId(){
        return id;
    }

    public String getNazev(){
        return nazev;
    }

    public String getPopis(){
        return popis;
    }

    public Mistnosti(String id, String nazev, String popis, ArrayList<String> soused, ArrayList<String> veciVMistnosti) {
        this.id = id;
        this.nazev = nazev;
        this.popis = popis;
        this.soused = soused;
        this.veciVMistnosti = veciVMistnosti;
    }
}
