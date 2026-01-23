package PridaneVeci;
import java.util.ArrayList;

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

}
