package ZavodniTridy;
import java.util.Random;
import HlavniTridy.StavHrace;
import HlavniTridy.Hra;

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
        String vystup = "";
        boolean safetyCar = false;
        if (rand.nextInt(100) < 12) {
            safetyCar = true;
        }
        boolean prsi = false;
        if (rand.nextInt(100) < 3) {
            prsi = true;
        }

        vystup = vystup + " kolo " + StavHrace.aktualniKolo + "/20 \n";
        if (prsi && !StavHrace.aktualniPneu.equals("WET")) {
            vystup = vystup + "Začalo pršt, Okamžitě jed do boxu pro pneu do mokra\n";
        }
        if (safetyCar) {
            vystup = vystup + "Safty car, ted je zákaz předjíždění (ideální doba pro pit stop).\n";
        }
        if (StavHrace.zivotnostPneu <= 0) {
            return vystup + "Guma explodovala kvůli opotřebovanosti. Nedojel jsi a prohrál si souboj o titul";
        }

        if (StavHrace.aktualniKolo == 20) {
            if (StavHrace.aktualniPozice == 1) {
                return vystup + "\n Dokázal si to, si mistr světa";
            } else {
                return vystup + "\n Jsi v cíli, dojel jsi na " + StavHrace.aktualniPozice + ". místě.\nMax vyhrál titul. Prohrál jsi souboj o titul.";
            }
        }

        StavHrace.aktualniKolo = StavHrace.aktualniKolo + 1;
        vystup = vystup + "\nPozice: " + StavHrace.aktualniPozice + " | Pneu: " + StavHrace.zivotnostPneu + "%\n";
        vystup = vystup + "Další příkaz: zrychli, neutral, setri, box";

        return vystup;

        }
    private static String odjetiKola(String styl, boolean sc, boolean prsi) {
        if (prsi && !StavHrace.aktualniPneu.equals("WET")) {
            StavHrace.aktualniPozice = StavHrace.aktualniPozice + 3;
            return "Na vodě jsi ztratil kontrolu, Propad o 3 místa.";
        }
        int opotrebeni = 0;
        int sanceNaPredjeti = 0;

        if (StavHrace.aktualniPneu.equals("SOFT")) {
            opotrebeni = 10;
            sanceNaPredjeti = 20;
        } else if (StavHrace.aktualniPneu.equals("MEDIUM")) {
            opotrebeni = 7;
            sanceNaPredjeti = 10;
        } else if (StavHrace.aktualniPneu.equals("HARD")) {
            opotrebeni = 5;
            sanceNaPredjeti = 0;
        } else if (StavHrace.aktualniPneu.equals("WET")) {
            opotrebeni = 5;
            sanceNaPredjeti = 10;
        }

        String zprava = "";
        if (styl.equals("zrychli")) {
            opotrebeni = opotrebeni + 5;
            sanceNaPredjeti = sanceNaPredjeti + 23;
            zprava = "Jedeš rychle, bacha na pneumatiky";
        } else if (styl.equals("setri")) {
            opotrebeni = opotrebeni - 3;
            sanceNaPredjeti = sanceNaPredjeti - 23;
            zprava = "Šetříš gumy.";
        } else {
            zprava = "Stabilní tempo.";
        }
    }
