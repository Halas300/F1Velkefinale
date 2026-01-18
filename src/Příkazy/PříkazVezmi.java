package Příkazy;

public class PříkazVezmi implements Příkaz {

    @Override
    public String getNazev() {
        return "vezmi";
    }

    @Override
    public void proved(String[] parametry) {
        if (parametry.length < 2) {
            System.out.println("Co chceš vzít?");
            return;
        }

        String nazevVeci = parametry[1];
        }
    }
