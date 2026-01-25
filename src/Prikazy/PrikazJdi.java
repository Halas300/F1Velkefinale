package Prikazy;

import HlavniTridy.Hra;
import PridaneVeci.Mistnosti;

public class PrikazJdi implements Prikaz {

    @Override
    public String getNazev() {
        return "jdi";
    }

    @Override
    public void proved(String[] parametry) {
        if (parametry.length < 2) {
            System.out.println("Musíš napsat, kam chceš jít (např. jdi garaz)");
            return;
        }

        String cil = parametry[1];
        boolean naselJsem = false;
        for (String idSouseda : Hra.aktualniLokace.soused) {
            Mistnosti sousedLokace = Hra.data.najdiMistnost(idSouseda);
            if (sousedLokace.getNazev().toLowerCase().contains(cil.toLowerCase())) {
                Hra.aktualniLokace = sousedLokace;
                System.out.println("Přešel jsi do: " + sousedLokace.getNazev());
                System.out.println(sousedLokace.getPopis());
                naselJsem = true;
                break;
            }
        }
        if (!naselJsem) {
            System.out.println("1. Odtud cesta nevede");
            System.out.println("2. Špatně zadaný příkaz");
        }
    }
}
