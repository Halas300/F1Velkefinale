package Příkazy;

public class PříkazPoužij implements Příkaz {

    @Override
    public String getNazev() {
        return "pouzij";
    }

    @Override
    public void proved(String[] parametry) {
        if (parametry.length < 2) {
            System.out.println("Co chceš použít?");
            return;
        }

        String nazev = parametry[1];
    }
}