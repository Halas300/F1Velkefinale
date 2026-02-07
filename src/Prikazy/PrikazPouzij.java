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
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            return "Co chceš použít?";
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
            return "Tuhle věc nemáš v batohu";
        }

        String idVeci = vecKPouziti.getId();
        String idMistnost = Hra.aktualniLokace.getId();

        if (idVeci.equals("item_naradi") && idMistnost.equals("loc_garaz")) {
            if (!StavHrace.autoOpraveno) {
                StavHrace.autoOpraveno = true;
                return "Použil jsi nářadí k opravě auta.\nAuto se opravuje...\nAuto bylo úspěšně opraveno";
            } else {
                return "Auto už je opravené.";
            }
        }

        else if (idVeci.equals("item_disk") && idMistnost.equals("loc_tech")) {
            if (!StavHrace.dataStazena) {
                StavHrace.dataStazena = true;
                return "Použil jsi disk na získání dat\nData se stahují...\nDle dat z treninku je doporučené nastavit křídla na 7 stupen";
            } else {
                return "Data už máš stažená";
            }
        }

        else if (idVeci.equals("item_tablet")) {
            String zprava = "Koukáš na tablet. Předpověď počasí je slunečnno. Teplota bude cca 30 a šance na déšt je malá\nDoporučujeme nejdříve stáhnout data z disku pro zjištění nejlepší strategie";
            if (StavHrace.dataStazena) {
                return "Doporučená strategie je startovat na soft a poté přezout na medium";
            }
        }
        return "Tady to použít nejde.";
    }
}