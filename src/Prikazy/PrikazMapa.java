package Prikazy;
import HlavniTridy.TextoveData;

public class PrikazMapa implements Prikaz {

    @Override
    public String getNazev() {
        return "mapa";
    }

    @Override
    public String proved(String[] parametry) {
        return TextoveData.nactiText("/napoveda.txt");
    }
}

