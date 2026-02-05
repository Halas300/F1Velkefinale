package Prikazy;

import HlavniTridy.Hra;
import PridaneVeci.Mistnosti;

public class PrikazJdi implements Prikaz {

    @Override
    public String getNazev() {
        return "jdi";
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            return "Musíš napsat, kam chceš jít (např. jdi garaz)";
        }

        String cil = parametry[1];
        for (String idSouseda : Hra.aktualniLokace.soused) {
            Mistnosti sousedLokace = Hra.data.najdiMistnost(idSouseda);
            if (sousedLokace.getNazev().toLowerCase().contains(cil.toLowerCase())) {
                Hra.aktualniLokace = sousedLokace;
                return "Přešel jsi do: " + sousedLokace.getNazev() + "\n" +
                        sousedLokace.getPopis();
            }
        }
        return "Tam odsud cesta nevede.";
        }
    }
