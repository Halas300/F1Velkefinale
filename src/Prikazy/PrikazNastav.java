package Prikazy;

public class PrikazNastav implements Prikaz {

    @Override
    public String getNazev() {
        return "nastav";
    }

    @Override
    public void proved(String[] parametry) {
        if (parametry.length < 3) {
            System.out.println("Použití: nastav [kridlo/pneu] [hodnota]");
            return;
        }

        String co = parametry[1];
        String hodnota = parametry[2];

    }
}