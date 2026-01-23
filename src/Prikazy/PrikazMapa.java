package Prikazy;

public class PrikazMapa implements Prikaz {

    @Override
    public String getNazev() {
        return "mapa";
    }

    @Override
    public void proved(String[] parametry) {
        System.out.println("                         ┌───────────────┐           ");
        System.out.println("                         │ 2. VIP LOUNGE │           ");
        System.out.println("                         │  (Christian)  │           ");
        System.out.println("                         └───────┬───────┘           ");
        System.out.println("                                 │                   ");
        System.out.println("              ┌───────────────┐  │  ┌───────────────┐");
        System.out.println("              │ 1. MOTORHOME  │  │  │ 3. MEDIA CTR  │");
        System.out.println("              │   Odpočinek   │  │  │   Rozhovory   │");
        System.out.println("              └───────┬───────┘  │  └───────┬───────┘");
        System.out.println("                      │          │          │        ");
        System.out.println("                      │   ┌──────▼──────────▼─────┐  ");
        System.out.println("                      └──▶│        PADDOCK        │  ");
        System.out.println("                          │    Centrální zóna     │  ");
        System.out.println("                     ┌───▶│  Pohyb mezi lokacemi  │  ");
        System.out.println("                     │    └────────────────▲──────┘  ");
        System.out.println("                     │                     │         ");
        System.out.println("             ┌───────────────┐    ┌───────────────┐  ");
        System.out.println("             │ 4. TECH CENTR │    │   5. GARÁŽ    │  ");
        System.out.println("             │   Data / AI   │ ┌─▶│  Úpravy auta  │  ");
        System.out.println("             └───────────────┘ │  └───────▲───────┘  ");
        System.out.println("                               │          │          ");
        System.out.println("                               │   ┌──────────────┐  ");
        System.out.println("                               │   │   6. SKLAD   │  ");
        System.out.println("                               │   │  Součástky   │  ");
        System.out.println("                               │   └──────────────┘  ");
        System.out.println("                               │                     ");
        System.out.println("                        ┌──────────────┐             ");
        System.out.println("                        │  7. PIT LANE │             ");
        System.out.println("                        │  Závod/Pneu  │             ");
        System.out.println("                        └──────────────┘             ");

    }
}

