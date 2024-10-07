package Buildings.Kingdoms;

import Buildings.Building;

import java.util.Random;

// Belong to a Kingdom
public class BlacksmithSchool extends Building {

    private final String[] schoolLevels = {"primary", "secondary", "graduate", "postgrad"};
    private String schoolLevel;

    public BlacksmithSchool(String buildingName, int buildingYearBuilt, int windows, int doors) {
        super(buildingName, buildingYearBuilt, windows, doors);

        Random rand = new Random();
        // Select school level at random
        schoolLevel = schoolLevels[rand.nextInt(0, schoolLevels.length)];
    }

    public String[] getSchoolLevels() {
        return schoolLevels;
    }

    public String getSchoolLevel() {
        return schoolLevel;
    }
}
