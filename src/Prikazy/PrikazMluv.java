package Prikazy;
import HlavniTridy.Hra;
import PridaneVeci.NPC;
import HlavniTridy.StavHrace;

public class PrikazMluv implements Prikaz {

    @Override
    public String getNazev() {
        return "mluv";
    }

    @Override
    public String proved(String[] parametry) {
        if (parametry.length < 2) {
            return "S kým chceš mluvit?";
        }

        String jmeno = parametry[1].toLowerCase();
        NPC nalezenaPostava = null;
        for (NPC postava : Hra.data.NPC) {
            if (postava.getDomovskaLokace().equals(Hra.aktualniLokace.getId())) {
                if (postava.getJmeno().toLowerCase().equals(jmeno)) {
                    nalezenaPostava = postava;
                    break;
                }
            }
        }

        if (nalezenaPostava == null) {
            return "Taková postava tu není.";
        }

        if (nalezenaPostava.getJmeno().equalsIgnoreCase("Sarah")) {
            if (StavHrace.rozhovorDokoncen) {
                return "Sarah: Už jsme spolu mluvili";
            }
            StavHrace.probihaRozhovor = true;
            StavHrace.cisloOtazky = 0;
            return "Sarah: Ahoj, jsem tvoje PR manažerka. Můžu s tebou udělat rozhovor? (Odpověz 'ano' nebo 'ne')";
        }
        if (nalezenaPostava.getJmeno().equalsIgnoreCase("James")) {
            return DialogJames();
        }

        return nalezenaPostava.getJmeno() + ": " + nalezenaPostava.getPoznamky();
    }

    private String DialogJames() {
        String james = "James: ";

        if (!StavHrace.autoOpraveno) {
            return james + "Ahoj, já jsem James, tvůj inženýr. Na úvod nemám úplně dobré zprávy – musíme narychlo opravit auto.\n" +
                    "Skoč prosím do skladu pro nářadí a přines ho do garáže. Jakmile budeš mít všechno po ruce, pustíme se do opravy.\n" +
                    "Až to bude hotové, posuneme se k dalšímu kroku.";
        }

        else if (!StavHrace.dataStazena) {
            return james + "Skvělá práce, auto by mělo být ready. Teď se musíme podívat na data.\n" +
                    "Zastav se v technickém centru pro USB disk a rovnou ho tam použij pro nahrání dat.\n" +
                    "Nahráním dat se ti odemknou podrobné informace v tabletu tady v garáži.\n" +
                    "Díky tabletu a disku budeme moct vyladit křídla a připravit strategii na závod. Jakmile to splníš, řeknu ti, co dál.";
        }

        else {
            return james + "Super, jsme ready. Teď už zbývá jen tvá výstroj – helmu a rukavice najdeš v motorhome.\n" +
                    "Pak už ti stačí udělat rozhovor a máš do startu volno. Doporučuji ti ten čas využít následovně:\n\n" +
                    "1. Media Center: Udělej rozhovor se Sarah, je potřeba zapracovat na dojmu u fanoušků. (povinnost)\n" +
                    "2. VIP Lounge: Stav se za šéfem týmu, může mít pár důležitých rad. (Doporučeno)\n" +
                    "3. Paddock: Můžeš si jít promluvit s Maxem, neváhej ho trochu rozhodit. (Volné rozhodnutí)\n" +
                    "Až budeš připraven, jdi do Pit Lane a začni závodit";
        }
    }
}
