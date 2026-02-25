package PridaneVeci;

import static org.junit.jupiter.api.Assertions.*;

class NPCTest {
    NPC testovaciNPC;

    @org.junit.jupiter.api.BeforeEach
    void init() {
        testovaciNPC = new NPC("npc_max", "Max", "Rival", "loc_paddock", "Jdu si pro titul.");
    }

    @org.junit.jupiter.api.Test
    void getId() {
        assertEquals("npc_max", testovaciNPC.getId());
    }

    @org.junit.jupiter.api.Test
    void getJmeno() {
        assertEquals("Max", testovaciNPC.getJmeno());
    }

    @org.junit.jupiter.api.Test
    void getRole() {
        assertEquals("Rival", testovaciNPC.getRole());
    }

    @org.junit.jupiter.api.Test
    void getDomovskaLokace() {
        assertEquals("loc_paddock", testovaciNPC.getDomovskaLokace());
    }

    @org.junit.jupiter.api.Test
    void getPoznamky() {
        assertEquals("Jdu si pro titul.", testovaciNPC.getPoznamky());
    }
}