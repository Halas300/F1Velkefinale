package Prikazy;
import HlavniTridy.TextoveData;

public class PrikazNapoveda implements Prikaz {

    @Override
    public String getNazev() {
        return "napoveda";
    }

    @Override
    public String proved(String[] parametry) {
        return TextoveData.nactiText("/napoveda.txt");
    }
}
