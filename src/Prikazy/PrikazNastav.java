package Prikazy;

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

    }
}