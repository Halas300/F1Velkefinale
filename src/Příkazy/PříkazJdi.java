package Příkazy;

public class PříkazJdi implements Příkaz {

    @Override
    public String getNazev() {
        return "jdi";
    }

    @Override
    public void proved(String[] parametry) {
        if (parametry.length < 2) {
            System.out.println("Musíš napsat, kam chceš jít! (např. 'jdi garaz')");
            return;
        }

        String cil = parametry[1];
        }
}
