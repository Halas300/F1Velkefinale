package PridaneVeci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VeciTest {
    Veci testovaciVec;

    @BeforeEach
    void init() {
        testovaciVec = new Veci("item_helma", "Helma", "Vybavení", "Tvoje závodní helma, bez ní nemůžeš jet.");
    }

    @Test
    void getId() {
        assertEquals("item_helma", testovaciVec.getId());
    }

    @Test
    void getNazev() {
        assertEquals("Helma", testovaciVec.getNazev());
    }

    @Test
    void getTyp() {
        assertEquals("Vybavení", testovaciVec.getTyp());
    }

    @Test
    void getPopis() {
        assertEquals("Tvoje závodní helma, bez ní nemůžeš jet.", testovaciVec.getPopis());
    }
}
