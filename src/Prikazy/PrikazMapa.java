package Prikazy;
import HlavniTridy.TextoveData;

/**
 * Příkaz pro zobrazení mapy z textového souboru.
 */
public class PrikazMapa implements Prikaz {

    @Override
    public String getNazev() {
        return "mapa";
    }

    @Override
    public String proved(String[] parametry) {
        return TextoveData.nactiText("/mapa.txt");
    }
}

