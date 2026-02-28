package Prikazy;
import HlavniTridy.TextoveData;

/**
 * Příkaz pro zobrazení nápovědy k herním příkazům.
 */
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
