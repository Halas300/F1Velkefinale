package HlavniTridy;

import PridaneVeci.Veci;
import PridaneVeci.Mistnosti;
import PridaneVeci.NPC;
import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Třída má herní data načtená z JSON souboru.
 * Obsahuje seznamy věcí, postav a místností.
 */
public class GameData {
    public ArrayList<Veci> Veci;
    public ArrayList<NPC> NPC;
    public ArrayList<Mistnosti> Mistnosti;

    /**
     * Načte herní data z JSON souboru.
     */
    public static GameData nactiData (String resourcePath) {
        Gson gson = new Gson();
        try (InputStream is = GameData.class.getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new IllegalStateException("Soubor " + resourcePath + " nebyl nalezen");
            }
            return gson.fromJson(new InputStreamReader(is, StandardCharsets.UTF_8), GameData.class);
        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }

    /**
     * Najde místnost podle jejího unikátního ID.
     */
    public Mistnosti najdiMistnost(String id) {
        for (Mistnosti l : Mistnosti) {
            if (l.getId().equals(id)) {
                return l;
            }
        }
        return null;
    }

    /**
     * Najde věc podle jejího unikátního ID.
     */
    public Veci NajdiVec(String id) {
        for (Veci i : Veci) {
            if (i.getId().equals(id)) return i;
        }
        return null;
    }
}
