package Territory;

import Buildings.Farms.FarmBarn;
import Buildings.Farms.FarmSilo;
import Buildings.Farms.FarmStable;
import Villagers.Villager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Farmland can host silos with farmers but not have forts with knights and forges with blacksmiths
public class Farmland extends Territory {

    private final Scanner scanner;
    private List<FarmBarn> farmBarns;
    private List<FarmSilo> farmSilos;
    private List<FarmStable> farmStables;

    public Farmland(String name, List<Villager> villagers) {
        super(name, villagers);

        this.scanner = new Scanner(System.in);
        this.farmBarns = new ArrayList<>();
        this.farmSilos = new ArrayList<>();
        this.farmStables = new ArrayList<>();

        initTerritoryFarm();
    }

    private void initTerritoryFarm() {
    }

}
