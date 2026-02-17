package HlavniTridy;

import PridaneVeci.Veci;
import java.util.ArrayList;

public class StavHrace {
    public static ArrayList<Veci> batoh = new ArrayList<>();
    public static final int KapacitaBatohu = 4;

    public static boolean autoOpraveno = false;
    public static boolean dataStazena = false;
    public static int nastavenoKridlo = 0;
    public static boolean probihaRozhovor = false;
    public static int cisloOtazky = 0;
    public static boolean rozhovorDokoncen = false;
    public static String sKymMluvim = "";
    public static boolean radaOdChristiana = false;
    public static int fazeHry = 0;
    public static int startovniPozice = 20;
    public static int aktualniPozice = 20;
    public static int aktualniKoloOtazka = 0;

}
