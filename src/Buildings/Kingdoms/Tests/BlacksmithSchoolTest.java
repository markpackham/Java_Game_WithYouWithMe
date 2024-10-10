package Buildings.Kingdoms.Tests;

import Buildings.Kingdoms.BlacksmithSchool;
import Villagers.Blacksmith;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        // Check the first name of the smith we added to the school is correct
        assertEquals(blacksmithSchool.getBlacksmiths().getFirst().getFirstName().equals("Dave"),"The blacksmith in our school really is Dave");

        // Check the only blacksmith that exists in the school is the sole one we created
        assertTrue(blacksmithSchool.getBlacksmiths().size() <2, "The correct number of blacksmiths exist in the school");
    }
}
