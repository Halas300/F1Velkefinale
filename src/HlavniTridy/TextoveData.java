package HlavniTridy;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * Třída pro načítání textových souborů (úvod a mapa hry).
 */
public class TextoveData {

    /**
     * Načte text z textového souboru z resources.
     */
    public static String nactiText(String cestaKSouboru) {
        try (InputStream is = TextoveData.class.getResourceAsStream(cestaKSouboru)) {
            if (is == null) {
                return "Chyba: Soubor " + cestaKSouboru + " nebyl nalezen.";
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                return reader.lines().collect(Collectors.joining("\n"));
            }
        } catch (Exception e) {
            return "Chyba při načítání textu: " + e.getMessage();
        }
    }
}
