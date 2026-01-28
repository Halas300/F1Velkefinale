package Prikazy;

import HlavniTridy.Hra;
import HlavniTridy.StavHrace;
import PridaneVeci.Veci;

public class PrikazVezmi implements Prikaz {

    @Override
    public String getNazev() {
        return "vezmi";
    }

    @Override
    public void proved(String[] parametry) {
        if (parametry.length < 2) {
            System.out.println("Co chceš vzít? (např. vezmi helma)");
            return;
        }

        String nazevVeci = parametry[1];
        if (StavHrace.batoh.size() >= StavHrace.KapacitaBatohu) {
            System.out.println("Batoh je plný, Něco musíš použít");
            return;
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
            System.out.println("Sebral jsi: " + predmetKteryChciPridat.getNazev());
        } else {
            System.out.println("Takový předmět tu není");
        }
    }
}
