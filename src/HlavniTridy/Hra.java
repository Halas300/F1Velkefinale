package HlavniTridy;

import PridaneVeci.Mistnosti;
import Prikazy.*;
import ZavodniTridy.Kvalifikace;
import ZavodniTridy.Zavod;

import java.util.ArrayList;
import java.util.Scanner;

public class Hra {
    public static Mistnosti aktualniLokace;
    public static GameData data;
    private ArrayList<Prikaz> seznamPrikazu = new ArrayList<>();
    boolean konec = false;

    public void start() {
        try {
            data = GameData.nactiData("/gamedata.json");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        aktualniLokace = data.najdiMistnost("loc_motorhome");
        if (aktualniLokace == null) {
            System.out.println("Chyba");
            return;
        }
        zacniPrikazy();
        Scanner sc = new Scanner(System.in);
        String uvodniText = TextoveData.nactiText("/uvod.txt");
        System.out.println(uvodniText);
        System.out.println("\nJsi v: " + aktualniLokace.getNazev());
        while (!konec) {
            String vstup = sc.nextLine();
            if (StavHrace.fazeHry == 0) {
            zpracujPrikaz(vstup);
            }
            else if (StavHrace.fazeHry == 1) {
                String vysledekKvalifikace = Kvalifikace.kvalda(vstup);
                System.out.println(vysledekKvalifikace);
            }
            else if (StavHrace.fazeHry == 2) {
                String vysledekZavodu = Zavod.zavodit(vstup);
                System.out.println(vysledekZavodu);
            }
        }
    }

    private void zacniPrikazy() {
        seznamPrikazu.add(new PrikazJdi());
        seznamPrikazu.add(new PrikazNapoveda());
        seznamPrikazu.add(new PrikazBatoh());
        seznamPrikazu.add(new PrikazVezmi());
        seznamPrikazu.add(new PrikazMapa());
        seznamPrikazu.add(new PrikazMluv());
        seznamPrikazu.add(new PrikazNastav());
        seznamPrikazu.add(new PrikazPouzij());
        seznamPrikazu.add(new PrikazProzkoumej());
        seznamPrikazu.add(new PrikazZahod());
    }

    private void zpracujPrikaz(String radek) {
        if (StavHrace.probihaRozhovor) {
            String odpovedSarah = Rozhovor.zpracujOdpoved(radek.trim());
            System.out.println(odpovedSarah);
            return;
        }
        String[] slova = radek.trim().split(" ");
        String nazev = slova[0].toLowerCase();
        if (nazev.equals("konec")) {
            konec = true;
            return;
        }
        boolean nalezeno = false;
        for (Prikaz p : seznamPrikazu) {
            if (p.getNazev().equals(nazev)) {
                String vysledek = p.proved(slova);
                System.out.println(vysledek);
                nalezeno = true;
                break;
            }
        }
        if (!nalezeno) {
            System.out.println("Neznámý příkaz.");
        }
    }
}