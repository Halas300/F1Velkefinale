package Prikazy;
import HlavniTridy.Hra;
import PridaneVeci.NPC;
import PridaneVeci.Veci;

/**
 * Příkaz pro vypsání informací o aktuální místnosti, věcech v ní a postavách.
 */
public class PrikazProzkoumej implements Prikaz {
    @Override
    public String getNazev() {
        return "prozkoumej";
    }
    @Override
    public String proved(String[] parametry) {
        String vystup = "";
        vystup += "Místnost: " + Hra.aktualniLokace.getNazev() + "\n";
        vystup += "Popis:    " + Hra.aktualniLokace.getPopis() + "\n";

        if (Hra.aktualniLokace.veciVMistnosti.isEmpty()) {
            vystup += "Předměty: Nejsou tady";
        } else {
            vystup += "Předměty: ";
            for (String idVeci : Hra.aktualniLokace.veciVMistnosti) {
                Veci v = Hra.data.NajdiVec(idVeci);
                if (v != null) {
                    vystup += v.getNazev();
                }
                vystup += "\n";
            }
        }

        vystup += "Postavy:  ";
        boolean nekdoTuJe = false;
        for (NPC postava : Hra.data.NPC) {
            if (postava.getDomovskaLokace().equals(Hra.aktualniLokace.getId())) {
                vystup += postava.getJmeno() + " (" + postava.getRole() + "), ";
                nekdoTuJe = true;
            }
        }
        if (!nekdoTuJe) {
            vystup += "Nikdo tu není.";
        }
        return vystup;
    }
}
