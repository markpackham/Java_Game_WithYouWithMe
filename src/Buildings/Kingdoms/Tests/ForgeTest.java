package Buildings.Kingdoms.Tests;

import Buildings.Kingdoms.Forge;
import Villagers.Blacksmith;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForgeTest {
    @Test
    public void testAddSmith() {
        // Create a school
        Forge forge = new Forge("Forge of Gold", 1066, 4, 1);

        // Create a smith
        Blacksmith blacksmith = new Blacksmith("Dave", "Smith", 15);

        // Add smith to the school
        forge.addSmith(blacksmith);

        // Check the school contains the smith
        assertTrue(forge.getBlacksmiths().contains(blacksmith), "The blacksmith has been added to the forge");

        // Check the first name of the smith we added to the school is correct
        assertTrue(forge.getBlacksmiths().getFirst().getFirstName().equals("Dave"),"The blacksmith in our forge really is Dave");

        // Check the only blacksmith that exists in the school is the sole one we created
        assertTrue(forge.getBlacksmiths().size() <2, "The correct number of blacksmiths exist in the forge");
    }
}
