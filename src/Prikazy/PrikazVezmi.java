package Prikazy;

import HlavniTridy.Hra;
import HlavniTridy.StavHrace;
import PridaneVeci.Veci;

/**
 * Příkaz pro sebrání předmětů.
 */
public class PrikazVezmi implements Prikaz {

    @Override
    public String getNazev() {
        return "vezmi";
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            return "Co chceš vzít? (např. vezmi helma)";
        }

        String nazevVeci = parametry[1];
        if (StavHrace.batoh.size() >= StavHrace.KapacitaBatohu) {
            return "Batoh je plný, Něco musíš použít";
        }

        boolean nalezeno = false;
        String idKtereChciSmazat = null;
        Veci predmetKteryChciPridat = null;
        for (String idVeci : Hra.aktualniLokace.veciVMistnosti) {
            Veci skutecnaVec = Hra.data.NajdiVec(idVeci);
            if (skutecnaVec != null) {
                if (skutecnaVec.getNazev().toLowerCase().contains(nazevVeci.toLowerCase())) {
                    predmetKteryChciPridat = skutecnaVec;
                    idKtereChciSmazat = idVeci;
                    nalezeno = true;
                    break;
                }
            }
        }

        if (nalezeno) {
            StavHrace.batoh.add(predmetKteryChciPridat);
            Hra.aktualniLokace.veciVMistnosti.remove(idKtereChciSmazat);
            return "Sebral jsi: " + predmetKteryChciPridat.getNazev();
        } else {
            return "Takový předmět tu není";
        }
    }
}
