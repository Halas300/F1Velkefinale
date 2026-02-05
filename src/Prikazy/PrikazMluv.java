package Prikazy;
import HlavniTridy.Hra;
import PridaneVeci.NPC;

public class PrikazMluv implements Prikaz {

    @Override
    public String getNazev() {
        return "mluv";
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            return "S kým chceš mluvit?";
        }

        String jmeno = parametry[1].toLowerCase();
        NPC nalezenaPostava = null;
        for (NPC postava : Hra.data.NPC) {
            if (postava.getDomovskaLokace().equals(Hra.aktualniLokace.getId())) {
                if (postava.getJmeno().toLowerCase().equals(jmeno)) {
                    nalezenaPostava = postava;
                    break;
                }
            }
        }

        if (nalezenaPostava != null) {
            return nalezenaPostava.getJmeno() + ": " + nalezenaPostava.getPoznamky();
        } else {
            return "Taková postava tu není.";
        }
    }
}
