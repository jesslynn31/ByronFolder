public class Energy extends Card {
    private int refuel = 1;
    private int energy;
    private final int maxEnergy = 100;
   

/**
 * Gets the current energy level of the pokemon.
 * 
 * @return the current energy level as an integer.
 */
public int getEnergy() {
    return energy;
}

/**
 * Refuels the pokemon's energy by a certain amount.
 * If the energy level goes past the maximum, it is set to the maximum.
 */
public void refuelEnergy() {
    energy += refuel;
    if (energy > maxEnergy) {
        energy = maxEnergy;
    }
}

/**
 * Uses a certain amount of energy, reducing the current energy level.
 * If the needed amount exceeds the available energy, no energy is used.
 * 
 * @param amount the amount of energy to use.
 */
public void useEnergy(int amount) {
    if (amount <= energy) {
        energy -= amount;
    }
}

/**
 * Gets the amount of energy that will be refueled.
 * 
 * @return the refuel amount as an integer.
 */
public int getRefuel() {
    return refuel;
}

@Override
public String toString() {
    return getName(); 
}

}
