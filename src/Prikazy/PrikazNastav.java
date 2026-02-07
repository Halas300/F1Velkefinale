package Prikazy;
import HlavniTridy.StavHrace;

public class PrikazNastav implements Prikaz {

    @Override
    public String getNazev() {
        return "nastav";
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 3) {
            return "Použití: nastav [kridlo/pneu] [hodnota]";
        }
        String co = parametry[1];
        String hodnota = parametry[2];

        if (co.equals("kridlo")) {
            try {
                int cislo = Integer.parseInt(hodnota);

                if (cislo >= 1 && cislo <= 10) {
                    StavHrace.nastavenoKridlo = cislo;
                    String zprava = "Mechanici nastavili přední křídlo na hodnotu " + cislo + ".";

                    if (cislo == 7) {
                        zprava += "\n(Mechanik je spokojený. Vypadá to správně.)";
                    }
                    return zprava;

                } else {
                    return "Hodnota musí být mezi 1 a 10.";
                }

            } catch (NumberFormatException e) {
                return "Musíš zadat číslo (např. 3)";
            }
        }

        return "Tohle neumím nastavit.";
    }
}