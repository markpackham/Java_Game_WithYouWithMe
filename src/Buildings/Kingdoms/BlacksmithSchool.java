package Buildings.Kingdoms;

import Buildings.Building;
import Villagers.Blacksmith;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Belong to a Kingdom
public class BlacksmithSchool extends Building {

    private final String[] schoolLevels = {"primary", "secondary", "graduate", "postgrad"};
    private final String schoolLevel;
    private List<Blacksmith> blacksmiths;

    public BlacksmithSchool(String buildingName, int buildingYearBuilt, int windows, int doors) {
        super(buildingName, buildingYearBuilt, windows, doors);

        Random rand = new Random();
        // Select school level at random
        schoolLevel = schoolLevels[rand.nextInt(0, schoolLevels.length)];
        this.blacksmiths = new ArrayList<>();
    }

    public String getSchoolLevel() {
        return schoolLevel;
    }
    public void addSmith(Blacksmith blacksmith) {
        this.blacksmiths.add(blacksmith);
    }

    public List<Blacksmith> getBlacksmiths() {
        return blacksmiths;
    }

}
