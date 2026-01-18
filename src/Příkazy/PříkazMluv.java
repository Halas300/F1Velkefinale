package Příkazy;

public class PříkazMluv implements Příkaz {

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

        String jmeno = parametry[1];

    }
}
