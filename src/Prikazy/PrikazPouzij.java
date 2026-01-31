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

        if (idVeci.equals("item_naradi") && idMistnost.equals("loc_garaz")) {
            if (!StavHrace.autoOpraveno) {
                System.out.println("Použil jsi nářadí k opravě auta.");
                System.out.println("Auto se opravuje...");
                System.out.println("Auto bylo úspěšně opraveno");
                StavHrace.autoOpraveno = true;
            } else {
                System.out.println("Auto už je opravené.");
            }
        }

        else if (idVeci.equals("item_disk") && idMistnost.equals("loc_tech")) {
            if (!StavHrace.dataStazena) {
                System.out.println("Použil jsi disk na získání dat");
                System.out.println("Data se stahují...");
                System.out.println("Dle dat z treninku je doporučené nastavit křídla na 7 stupen");
                StavHrace.dataStazena = true;
            } else {
                System.out.println("Data už máš stažená");
            }
        }
    }
}