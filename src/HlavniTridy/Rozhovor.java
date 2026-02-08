package HlavniTridy;

public class Rozhovor {

    public static String zpracujOdpoved(String odpovedHrace) {
        if (StavHrace.sKymMluvim.equals("Sarah")) {
            return zpracujSarah(odpovedHrace);
        }
        else if (StavHrace.sKymMluvim.equals("Max")) {
            return zpracujMaxe(odpovedHrace);
        }
        else if (StavHrace.sKymMluvim.equals("Christian")) {
            return zpracujChristiana(odpovedHrace);
        }

        return "Chyba: Nevím s kým mluvíš.";
    }

        private static String zpracujSarah(String odpovedHrace) {
        if (StavHrace.cisloOtazky == 0) {
            if (odpovedHrace.toLowerCase().equals("ano")) {
                StavHrace.cisloOtazky++;
                return "Sarah: Super, tak můžeme začít.\n" +
                        "Otázka 1: Máte s rivalem shodný počet bodů. Je to pro vás dnes jen další sobota, " +
                        "nebo cítíte, že je v sázce víc než kdykoliv předtím?";
            } else if (odpovedHrace.toLowerCase().equals("ne")) {
                StavHrace.probihaRozhovor = false;
                return "Sarah: Tak snad příště. (Rozhovor ukončen)";
            } else {
                return "Sarah: Prosím odpověz 'ano' nebo 'ne'.";
            }
        }

        if (StavHrace.cisloOtazky == 1) {
            StavHrace.cisloOtazky++;
            return "Sarah: Zajímavé.\n" +
                    "Otázka 2: Pokud se v první zatáčce ocitnete kolo na kolo, jste ochoten riskovat kolizi, aby se nedostal před vás?";
        }

        if (StavHrace.cisloOtazky == 2) {
            StavHrace.cisloOtazky++;
            return "Sarah: Rozumím.\n" +
                    "Otázka 3: Čeká Vás asi nejdůležitější kvalifikace sezony. Jak moc si v ní věříte?";
        }

        if (StavHrace.cisloOtazky == 3) {
            StavHrace.cisloOtazky++;
            return "Sarah: Dobře, poslední otázka.\n" +
                    "Otázka 4: Podle našich informací máte nějaký technický problém s autem. Je vše v pořádku nebo máte nějaké obavy?";
        }

        if (StavHrace.cisloOtazky == 4) {
            StavHrace.probihaRozhovor = false;
            StavHrace.rozhovorDokoncen = true;
            return "Sarah: Díky za upřímnost. To je pro dnešek vše, držím palce v závodě\n(Rozhovor dokončen)";
        }

        return "Chyba v rozhovoru.";
    }

    private static String zpracujMaxe(String odpovedHrace) {
        String volba = odpovedHrace.toUpperCase();

        if (!volba.equals("A") && !volba.equals("B") && !volba.equals("C")) {
            return "Napiš A nebo B nebo C";
        }

        if (StavHrace.cisloOtazky == 0) {
            StavHrace.cisloOtazky ++;
            return "Max: Všichni mluví o tom, jaký jsi talent. Ale víš, jak to chodí – historie si pamatuje jen vítěze.\n" +
                    "Jsi připravený na to, že zítra budeš pro všechny jen ten, co skončil druhý?\n\n" +
                    "A) Tlak mě nezajímá. Jediné, co cítím, je motor za mými zády.\n" +
                    "B) To zní, jako bys už teď mluvil o sobě. Už máš nacvičený proslov pro poražené?\n" +
                    "C) Dneska vyhraje ten, kdo udělá o jednu chybu míň.";
        }

        if (StavHrace.cisloOtazky == 1) {
            StavHrace.cisloOtazky ++;
            return "Max: Jen si ujasněme jednu věc. Dneska ti nenechám ani milimetr místa.\n" +
                    "Jestli tam tu ruku strčíš, tak počítej s tím, že ani jeden nedojedeme.\n\n" +
                    "A) Chci vyhrát čistě. Ale jestli mě vytlačíš, nenechám to jen tak.\n" +
                    "B) Takhle snadno mě nezastrašíš. Jestli do mě narazíš, vezmeš ten titul s sebou do bariéry.\n" +
                    "C) Míň mluv, víc jezdi. Uvidíme se na trati.";
        }

        if (StavHrace.cisloOtazky == 2) {
            StavHrace.probihaRozhovor = false;
            return "Max: Fajn. Užij si ten pohled na moje zadní křídlo.\n(Max si nasadil sluchátka a odešel.)";
        }

        return "Chyba u Maxe.";
    }

    private static String zpracujChristiana(String odpovedHrace) {
        String volba = odpovedHrace.toUpperCase();

        if (!volba.equals("A") && !volba.equals("B") && !volba.equals("C")) {
            return "Napiš A nebo B nebo C";
        }

        if (StavHrace.cisloOtazky == 0) {
            StavHrace.cisloOtazky ++;
            return "Christian: Dobře.\n" +
                    "Jde o všechno. Půjdeš do totálního rizika, nebo pojedeš na jistotu?\n\n" +
                    "A) Beru jen zlato. Riziko k tomu patří.\n" +
                    "B) Pojedu hlavou. Hlavně to dojet.\n" +
                    "C) Uvidím podle situace. Věřte mi.";
        }

        if (StavHrace.cisloOtazky == 1) {
            StavHrace.cisloOtazky ++;
            return "Christian: Rozumím.\n" +
                    "Podívej se na ty lidi v garáži. Všichni tu dneska věří jen v tebe. Cítíš tu energii?\n\n" +
                    "A) Je to motor, co mě žene vpřed. Nezklameme je.\n" +
                    "B) Snažím se to nevnímat. Musím se soustředit na jízdu.\n" +
                    "C) Hlavně doufám, že neudělají chybu při zastávce.";
        }

        if (StavHrace.cisloOtazky == 2) {
            StavHrace.cisloOtazky ++;
            return "Christian: Jasně.\n" +
                    "Kdyby začalo pršet, budeme muset improvizovat. Věříš mému úsudku od zdi, nebo si to na trati rozhodneš sám?\n\n" +
                    "A) Věřím vám. Máte víc dat než já v kokpitu.\n" +
                    "B) Já jsem v tom autě. Konečné slovo mám já.\n" +
                    "C) Budeme mluvit do vysílačky. Společně to trefíme.";
        }

        if (StavHrace.cisloOtazky == 3) {
            StavHrace.probihaRozhovor = false;
            StavHrace.radaOdChristiana = true;
            // ještě bude dopsáno
            return "Christian: Nějaká Rada";
        }

        return "Chyba u Christiana.";
    }
}
