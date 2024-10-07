package Buildings.Tests;

import Buildings.Kingdoms.Fort;
import Villagers.Knight;

import java.util.List;

// Unit tests from JUnit
// https://www.jetbrains.com/help/idea/create-tests.html#naming-pattern-for-tests
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FortTest {

    private Fort fort;
    private Knight knight, knight2;

    @BeforeEach
    void setUp() {
        fort = new Fort("Test Fort", 1000, 2, 1);
        knight = new Knight("Test Knight", "Test Knight Surname", 31);
        knight2 = new Knight("Test Knight2", "Test Knight Surname2", 32);
    }

    @Test
    void testGetFortID() {
        // FortID uses a UUID (ergo random) so we can only test to see if it is null
        assertNotNull(fort.getFortID(), "FortID must not be null");
    }

    @Test
    void testAddKnight() {
        fort.addKnight(knight);
        fort.addKnight(knight2);
        List<Knight> knights = fort.getKnights();
        assertEquals(2, knights.size(), "The fort must have 2 knights");
    }

    @Test
    void testGetKnights() {
        fort.addKnight(knight);
        List<Knight> knights = fort.getKnights();
        assertEquals(2, knights.size(), "The list must have 2 knights in it");
    }
}