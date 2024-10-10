package Buildings.Kingdoms.Tests;

import Buildings.Kingdoms.BlacksmithSchool;
import Villagers.Blacksmith;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlacksmithSchoolTest {
    @Test
    public void testAddSmith() {
        // Create a school
        BlacksmithSchool blacksmithSchool = new BlacksmithSchool("School of Gold Smiting", 1066, 4, 1);

        // Create a smith
        Blacksmith blacksmith = new Blacksmith("Dave", "Smith", 15);

        // Add smith to the school
        blacksmithSchool.addSmith(blacksmith);

        // Check the school contains the smith
        assertTrue(blacksmithSchool.getBlacksmiths().contains(blacksmith), "The blacksmith has been added to the school");
    }
}
