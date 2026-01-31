package Prikazy;
import HlavniTridy.Hra;
import HlavniTridy.StavHrace;
import PridaneVeci.Veci;

public class PrikazPouzij implements Prikaz {

    @Override
    public String getNazev() {
        return "pouzij";
    }

    @Override
    public void proved(String[] parametry) {
        if (parametry.length < 2) {
            System.out.println("Co chceš použít?");
            return;
        }

        String nazev = parametry[1].toLowerCase();
        Veci vecKPouziti = null;
        for (Veci v : StavHrace.batoh) {
            if (v.getNazev().toLowerCase().contains(nazev)) {
                vecKPouziti = v;
                break;
            }
        }

        if (vecKPouziti == null) {
            System.out.println("Tuhle věc nemáš v batohu");
            return;
        }

        String idVeci = vecKPouziti.getId();
        String idMistnost = Hra.aktualniLokace.getId();

    }
}