package Prikazy;

import HlavniTridy.StavHrace;
import PridaneVeci.Veci;

public class PrikazBatoh implements Prikaz {

    @Override
    public String getNazev() {
        return "batoh";
    }

    @Override
    public String proved(String[] parametry) {
        if (StavHrace.batoh.isEmpty()) {
            return "Batoh je prázdný.";
        }

        String vystup = "OBSAH BATOHU\n";

        for (Veci v : StavHrace.batoh) {
            vystup += "Místo: " + StavHrace.batoh.size() + "/" + StavHrace.KapacitaBatohu;
        }
        return vystup;
    }
}
