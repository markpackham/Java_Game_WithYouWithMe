package Villagers.Tests;

import Villagers.Blacksmith;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlacksmithTest {
    @Test
    public void testConstructorAndSkillLevel() {
        // Create a blacksmith
        Blacksmith blacksmith = new Blacksmith("Dave", "Smith", 19);

        // Check blacksmith attributes are correct on creation
        assertEquals("Dave", blacksmith.getFirstName());
        assertEquals("Smith", blacksmith.getSurname());
        assertEquals(19, blacksmith.getAge());

        // Skill level must be an expected value
        assertTrue(
                blacksmith.getSkillLevel().equals("apprentice") ||
                        blacksmith.getSkillLevel().equals("journeyman") ||
                        blacksmith.getSkillLevel().equals("master"),
                "Skill level be apprentice, journeyman or master."
        );
    }
}
