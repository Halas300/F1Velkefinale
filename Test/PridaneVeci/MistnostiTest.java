package PridaneVeci;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class MistnostiTest {
    Mistnosti testovaciMistnost;

    @BeforeEach
    void init() {
        ArrayList<String> sousedi = new ArrayList<>();
        sousedi.add("loc_pitlane");
        ArrayList<String> veci = new ArrayList<>();
        veci.add("item_naradi");

        testovaciMistnost = new Mistnosti("loc_garaz", "Garáž", "Tady se opravuje auto.", sousedi, veci);
    }

    @Test
    void getId() {
        assertEquals("loc_garaz", testovaciMistnost.getId());
    }

    @Test
    void getNazev() {
        assertEquals("Garáž", testovaciMistnost.getNazev());
    }

    @Test
    void getPopis() {
        assertEquals("Tady se opravuje auto.", testovaciMistnost.getPopis());
    }
}