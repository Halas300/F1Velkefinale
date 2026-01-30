package Prikazy;
import HlavniTridy.Hra;
import PridaneVeci.NPC;

public class PrikazMluv implements Prikaz {

    @Override
    public String getNazev() {
        return "mluv";
    }

    @Override
    public void proved(String[] parametry) {
        if (parametry.length < 2) {
            System.out.println("S kým chceš mluvit?");
            return;
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
            System.out.println(nalezenaPostava.getJmeno() + ": " + nalezenaPostava.getPoznamky());
        } else {
            System.out.println("Taková postava tu není.");
        }
    }
}
