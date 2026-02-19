package ZavodniTridy;
import java.util.Random;
import HlavniTridy.StavHrace;

public class Zavod {
    public static String zavodit (String vstup) {
        String akce = vstup.toLowerCase();
        Random rand = new Random();
        if (StavHrace.aktualniKolo == 0) {
            String volba = akce.trim().toUpperCase();
            switch (volba) {
                case "SOFT":
                    StavHrace.aktualniPneu = "SOFT";
                    break;
                case "MEDIUM":
                    StavHrace.aktualniPneu = "MEDIUM";
                    break;
                case "HARD":
                    StavHrace.aktualniPneu = "HARD";
                    break;
                default:
                    return "Neplatná volba. Napiš SOFT, MEDIUM nebo HARD.";
            }
            StavHrace.zivotnostPneu = 100;
            StavHrace.aktualniKolo = 1;
            String startText = "Pneu vybrány: " + StavHrace.aktualniPneu + "\n";
            startText = startText + "Ted už jsme připraveni závodit\n";
            startText = startText + "Závod právě odstartoval...";
            startText = startText + "Napiš příkaz pro toto kolo: zrychli, neutral, setri, box";
            return startText;
        }
        }
    }
