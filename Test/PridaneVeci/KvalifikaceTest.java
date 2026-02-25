package PridaneVeci;

import HlavniTridy.StavHrace;
import ZavodniTridy.Kvalifikace;
import static org.junit.jupiter.api.Assertions.*;

public class KvalifikaceTest {

    @org.junit.jupiter.api.BeforeEach
    void init() {
        StavHrace.aktualniKoloOtazka = 0;
        StavHrace.startovniPozice = 2;
    }

    @org.junit.jupiter.api.Test
    void SpravnaOdpoved() {
        Kvalifikace.kvalda("A");
        assertEquals(2, StavHrace.startovniPozice);
        assertEquals(1, StavHrace.aktualniKoloOtazka);
    }

    @org.junit.jupiter.api.Test
    void ZhorseniPozice() {
        Kvalifikace.kvalda("B");
        assertEquals(3, StavHrace.startovniPozice);
        assertEquals(1, StavHrace.aktualniKoloOtazka);
    }

    @org.junit.jupiter.api.Test
    void Vstup() {
        String vysledek = Kvalifikace.kvalda("X");
        assertEquals("Odpověz prosím A, B nebo C.", vysledek);
        assertEquals(0, StavHrace.aktualniKoloOtazka);
        assertEquals(2, StavHrace.startovniPozice);
    }
}
