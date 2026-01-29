package Prikazy;

import HlavniTridy.StavHrace;
import PridaneVeci.Veci;

public class PrikazBatoh implements Prikaz {

    @Override
    public String getNazev() {
        return "batoh";
    }

    @Override
    public void proved(String[] parametry) {
        if (StavHrace.batoh.isEmpty()) {
            System.out.println("Batoh je prázdný.");
            return;
        }

        for (Veci v : StavHrace.batoh) {
            System.out.println(v.getNazev() + " (" + v.getPopis() + ")");
        }

        System.out.println("Místo: " + StavHrace.batoh.size() + "/" + StavHrace.KapacitaBatohu);
    }
}
