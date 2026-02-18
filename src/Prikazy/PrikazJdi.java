package Prikazy;

import HlavniTridy.Hra;
import HlavniTridy.StavHrace;
import PridaneVeci.Mistnosti;
import PridaneVeci.Veci;

public class PrikazJdi implements Prikaz {

    @Override
    public String getNazev() {
        return "jdi";
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            return "Musíš napsat, kam chceš jít (např. jdi garaz)";
        }

        String cil = parametry[1];
        for (String idSouseda : Hra.aktualniLokace.soused) {
            Mistnosti sousedLokace = Hra.data.najdiMistnost(idSouseda);
            if (sousedLokace.getNazev().toLowerCase().contains(cil.toLowerCase())) {
                if (sousedLokace.getId().equals("loc_pitlane")) {

                    boolean vseSplneno = true;
                    String chybi = "";
                    if (!StavHrace.autoOpraveno) {
                        vseSplneno = false;
                        chybi = chybi + "Opravit auto\n";
                    }
                    if (!StavHrace.dataStazena) {
                        vseSplneno = false;
                        chybi = chybi + "Stáhnout data \n";
                    }
                    if (StavHrace.nastavenoKridlo == 0) {
                        vseSplneno = false;
                        chybi = chybi + "Nastavit křídlo \n";
                    }
                    if (!StavHrace.rozhovorDokoncen) {
                        vseSplneno = false;
                        chybi = chybi + "Udělat rozhovor se Sarah\n";
                    }
                    boolean mamHelmu = false;
                    boolean mamrukavice = false;

                    for (Veci v : StavHrace.batoh) {
                        if (v.getId().equals("item_helma")) {
                            mamHelmu = true;
                        }
                        if (v.getId().equals("item_rukavice")) {
                            mamrukavice = true;
                        }
                    }
                    if (mamHelmu == false) {
                        vseSplneno = false;
                        chybi = chybi + "Vzít si Helmu \n";
                    }
                    if (mamrukavice == false) {
                        vseSplneno = false;
                        chybi = chybi + "Vzít si Rukavice \n";
                    }
                    if (vseSplneno == false) {
                        return "Ještě nemůžeš vstoupit do kvalifikace. Ještě ti chybí:\n" + chybi;
                    }
                    if (StavHrace.nastavenoKridlo != 7) {
                        StavHrace.startovniPozice = StavHrace.startovniPozice + 1;
                    }
                    StavHrace.fazeHry = 1;
                    StavHrace.aktualniKoloOtazka = -1;
                    return "Vše máš splněno, takže můžeš nastoupit do kvalifikace.\n" +
                            "Stiskni Enter pro start";
                }

                Hra.aktualniLokace = sousedLokace;
                return "Přešel jsi do: " + sousedLokace.getNazev() + "\n" +
                        sousedLokace.getPopis();
            }
        }
        return "Tam odsud cesta nevede.";
        }
    }
