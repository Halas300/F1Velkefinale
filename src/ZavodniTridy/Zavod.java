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
        if (StavHrace.vBoxech) {
            String volba = akce.trim().toLowerCase();
            switch (volba) {
                case "soft":
                    StavHrace.aktualniPneu = "SOFT";
                    break;

                case "medium":
                    StavHrace.aktualniPneu = "MEDIUM";
                    break;

                case "hard":
                    StavHrace.aktualniPneu = "HARD";
                    break;

                case "wet":
                    StavHrace.aktualniPneu = "WET";
                    break;

                default:
                    return "Napiš prosím SOFT, MEDIUM, HARD nebo WET";
            }
            StavHrace.zivotnostPneu = 100;
            StavHrace.vBoxech = false;
            int ztrataPozic = 4;
            StavHrace.aktualniPozice = StavHrace.aktualniPozice + ztrataPozic;
            String zpravaZBoxu = "Mechanici přezuli na " + StavHrace.aktualniPneu + "\n";
            zpravaZBoxu = zpravaZBoxu + "Ztratil jsi " + ztrataPozic + " pozic a seš na " + StavHrace.aktualniPozice + " místě\n";
            zpravaZBoxu = zpravaZBoxu + "Jedeš dál. Napiš příkaz: zrychli, neutral, setri, box";

            return zpravaZBoxu;
        }
        String vystup = "";
        boolean safetyCar = false;
        if (rand.nextInt(100) < 16) {
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
        if (akce.equals("box")) {
            StavHrace.vBoxech = true;
            StavHrace.aktualniKolo = StavHrace.aktualniKolo + 1;
            return vystup + "Zajíždíš do boxů \nNapiš jaké pneu chceš nasadit: SOFT, MEDIUM, HARD nebo WET";
        }
        else {
            vystup = vystup + odjetiKola(akce, safetyCar, prsi);
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
            sanceNaPredjeti = 14;
        } else if (StavHrace.aktualniPneu.equals("HARD")) {
            opotrebeni = 5;
            sanceNaPredjeti = 10;
        } else if (StavHrace.aktualniPneu.equals("WET")) {
            opotrebeni = 5;
            sanceNaPredjeti = 16;
        }

        String zprava = "";
        if (styl.equals("zrychli")) {
            opotrebeni = opotrebeni + 6;
            sanceNaPredjeti = sanceNaPredjeti + 20;
            zprava = "Jedeš rychle, bacha na pneumatiky";
        } else if (styl.equals("setri")) {
            opotrebeni = opotrebeni - 6;
            sanceNaPredjeti = sanceNaPredjeti - 20;
            zprava = "Šetříš gumy.";
        } else {
            zprava = "Stabilní tempo.";
        }
        if (sc) {
            opotrebeni = 1;
            sanceNaPredjeti = -1000;
            zprava = "Kroužení za SC.";
        }

        StavHrace.zivotnostPneu = StavHrace.zivotnostPneu - opotrebeni;
        Random random = new Random();
        int nahoda = random.nextInt(100);
        if (sanceNaPredjeti > 0 && nahoda < sanceNaPredjeti) {
            if (StavHrace.aktualniPozice > 1) {
                StavHrace.aktualniPozice = StavHrace.aktualniPozice - 1;
                return zprava + " Předjel si soupeře";
            }
        }
        if (sanceNaPredjeti < 0 || nahoda > (100 - opotrebeni)) {
            StavHrace.aktualniPozice = StavHrace.aktualniPozice + 1;
            return zprava + " Soupeř tě předjel";
        }

        return zprava + " Pozice se nemění";
    }
    }
