package Buildings.Farms;

import Villagers.Farmer;

import java.util.List;

// Every farmland building needs the ability to add a farmer & get them so this interface must be used
public interface AddFarmer {
    void addFarmer(Farmer farmer);

    List<Farmer> getFarmers();
}
