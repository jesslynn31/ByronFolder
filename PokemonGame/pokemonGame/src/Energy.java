public class Energy extends Card {
    private int refuel = 1;
    private int energy;
    private final int maxEnergy = 100;
   

    public void setEnergy(int userInputEnergy) {
        energy = userInputEnergy;
    }

    public int getEnergy() {
        return energy;
    }

    public void refuelEnergy() {
        energy += refuel;
        if (energy > maxEnergy) {
            energy = maxEnergy;
        }
    }

   


    public void useEnergy(int amount) {
        if (amount <= energy) {
            energy -= amount;
        }
    }

    public int getRefuel() {
        return refuel;
    }

    public void setRefuel(int userInputRefuel) {
        refuel = userInputRefuel;
    }
} 
