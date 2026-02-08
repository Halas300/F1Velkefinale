package HlavniTridy;

public class Rozhovor {

    public static String zpracujOdpoved(String odpovedHrace) {

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
}
