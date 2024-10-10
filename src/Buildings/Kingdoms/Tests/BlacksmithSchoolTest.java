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
        assertEquals("Dave", blacksmithSchool.getBlacksmiths().getFirst().getFirstName(), "The blacksmith in our school really is Dave");

        // Check the only blacksmith that exists in the school is the sole one we created
        assertTrue(blacksmithSchool.getBlacksmiths().size() < 2, "The correct number of blacksmiths exist in the school");

        // School level must be an expected value
        assertTrue(
                blacksmithSchool.getSchoolLevel().equals("primary") ||
                        blacksmithSchool.getSchoolLevel().equals("secondary") ||
                        blacksmithSchool.getSchoolLevel().equals("graduate") ||
                        blacksmithSchool.getSchoolLevel().equals("postgrad") ||
                        blacksmithSchool.getSchoolLevel().equals("inventor"),
                "Skill level be one of the 5 listed ones."
        );
    }
}
