package Prikazy;
import HlavniTridy.Hra;
import HlavniTridy.StavHrace;
import PridaneVeci.Veci;

public class PrikazZahod implements Prikaz{
    @Override
    public String getNazev() {
        return "zahod";
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            return "Co chceš zahodit? (např. zahod helma)";
        }

        String nazevVeci = parametry[1].toLowerCase();
        Veci vecKZahozeni = null;

        for (Veci v : StavHrace.batoh) {
            if (v.getNazev().toLowerCase().contains(nazevVeci)) {
                vecKZahozeni = v;
                break;
            }
        }

        if (vecKZahozeni == null) {
            return "Takovou věc v batohu nemáš.";
        }

        StavHrace.batoh.remove(vecKZahozeni);
        Hra.aktualniLokace.veciVMistnosti.add(vecKZahozeni.getId());
        return "Zahodil jsi: " + vecKZahozeni.getNazev();
    }
}
