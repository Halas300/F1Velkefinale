package ZavodniTridy;
import HlavniTridy.StavHrace;

/**
 * Třída pro kvalifikaci před závodem.
 * Podle odpovědí určuje startovní pozici.
 */
public class Kvalifikace {
    private static String[][] otazky = {
            {
                    "Proč je důležité správně načasovat brzdění do nájezdu na nejdelší rovinku?",
                    "Aby jezdec získal co nejlepší trakci na výjezdu a maximalizoval účinek DRS.",
                    "Aby se zabránilo přehřátí předních pneumatik.",
                    "Kvůli úspoře paliva.",
                    "0"
            },
            {
                    "Jakou taktiku používají jezdci v sektoru 3 ohledně pneumatik?",
                    "Agresivní jízda přes obrubníky.",
                    "Precizní stopa a šetření zadních pneumatik.",
                    "Maximalizace rychlosti v nájezdu.",
                    "1"
            },
            {
                    "Jaký strategický význam má v Abu Dhabi undercut?",
                    "Malý, výjezd je pomalý.",
                    "Zanedbatelný.",
                    "Vysoký, čerstvé pneu umožní získat náskok.",
                    "2"
            },
            {
                    "Jaký dopad měla úprava tratě v roce 2021?",
                    "Zvýšila se rychlost a šance na předjíždění.",
                    "Trať se stala pomalejší.",
                    "Změny neměly vliv.",
                    "0"
            },
            {
                    "Který jezdec drží rekord v počtu titulů (s Schumacherem)?",
                    "Max Verstappen",
                    "Lewis Hamilton",
                    "Sebastian Vettel",
                    "1"
            },
            {
                    "Co znamená vyvěšení modré vlajky?",
                    "Nebezpečí na trati.",
                    "Pomalejší jezdec musí pustit rychlejšího.",
                    "Konec tréninku.",
                    "1"
            },
            {
                    "Na kterém okruhu se jede VC Itálie (Chrám rychlosti)?",
                    "Imola",
                    "Monza",
                    "Mugello",
                    "1"
            },
            {
                    "Co je to systém DRS?",
                    "Pohyblivé zadní křídlo pro snazší předjíždění.",
                    "Rekuperace energie.",
                    "Režim motoru.",
                    "0"
            },
            {
                    "Co je to přísavný efekt (Ground Effect)?",
                    "Ventilátory vysávají vzduch.",
                    "Tvarovaná podlaha vytváří podtlak.",
                    "Magnetické pole v asfaltu.",
                    "1"
            },
            {
                    "K čemu slouží prvek zvaný „Halo“?",
                    "Zlepšení sání motoru.",
                    "Ochrana hlavy jezdce.",
                    "Upevnění kamer.",
                    "1"
            }
    };
        /**
         * Zpracovává odpovědi hráče v průběhu kvalifikace.
         */
        public static String kvalda(String vstup) {
                if (StavHrace.aktualniKoloOtazka == -1) {
                        StavHrace.aktualniKoloOtazka = 0;
                        String uvod = "Vítej v kvalifikaci\n";
                        uvod = uvod + "Zkus odpovědět správně na otázky a získej dobrou sartovací pozici\n";
                        uvod = uvod + vypisOtazky(0);
                        return uvod;
                }

                String odpoved = vstup.toUpperCase();
                int indexVolby;
                switch (odpoved) {
                        case "A":
                                indexVolby = 0;
                                break;
                        case "B":
                                indexVolby = 1;
                                break;
                        case "C":
                                indexVolby = 2;
                                break;
                        default:
                                return "Odpověz prosím A, B nebo C.";
                }

                int spravne = Integer.parseInt(otazky[StavHrace.aktualniKoloOtazka][4]);
                if (indexVolby != spravne) {
                        StavHrace.startovniPozice = StavHrace.startovniPozice + 1;
                }
                StavHrace.aktualniKoloOtazka = StavHrace.aktualniKoloOtazka + 1;
                if (StavHrace.aktualniKoloOtazka >= 10) {
                        StavHrace.fazeHry = 2;
                        StavHrace.aktualniKoloOtazka = 0;
                        StavHrace.aktualniPozice = StavHrace.startovniPozice;
                        String konec = "Kvalifikace dokončena\n";
                        konec = konec + "Startuješ z " + StavHrace.startovniPozice + " místa.\n";
                        konec = konec + "Rovnou si připrav startovací pneumatiky na závod\n";
                        konec = konec + "Napiš na čem chceš startovat: SOFT, MEDIUM nebo HARD";
                        return konec;
                }

                return vypisOtazky(StavHrace.aktualniKoloOtazka);
        }
        /**
         * Pomocná metoda pro vypsání otázky
         */
        private static String vypisOtazky(int index) {
                String text = " Otázka " + (index + 1) + ": " + otazky[index][0] + "\n";
                text = text + "A) " + otazky[index][1] + "\n";
                text = text + "B) " + otazky[index][2] + "\n";
                text = text + "C) " + otazky[index][3] + "\n";
                return text;
        }
}
