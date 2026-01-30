package HlavniTridy;

import PridaneVeci.Mistnosti;
import Prikazy.*;
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
        System.out.println(" F1 - Velké Finále ");
        System.out.println("Jsi v: " + aktualniLokace.getNazev());
        while (!konec) {
            String vstup = sc.nextLine();
            zpracujPrikaz(vstup);
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
    }

    private void zpracujPrikaz(String radek) {
        String[] slova = radek.trim().split(" ");
        String nazev = slova[0].toLowerCase();
        if (nazev.equals("konec")) {
            konec = true;
            return;
        }
        for (Prikaz p : seznamPrikazu) {
            if (p.getNazev().equals(nazev)) {
                p.proved(slova);
                return;
            }
        }
        System.out.println("Neznámý příkaz.");
    }
}