package Villagers.Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Villagers.Blacksmith;

public class BlacksmithTest {
    @Test
    public void testConstructorAndSkillLevel() {
        // Create a blacksmith
        Blacksmith blacksmith = new Blacksmith("Dave", "Smith", 19);

        // Skill level must be an expected value
        assertTrue(
                blacksmith.getSkillLevel().equals("apprentice") ||
                        blacksmith.getSkillLevel().equals("journeyman") ||
                        blacksmith.getSkillLevel().equals("master"),
                "Skill level be apprentice, journeyman or master."
        );
    }
}
