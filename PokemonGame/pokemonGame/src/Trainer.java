
public class Trainer extends Card {
   
    private int id;
    private int badges;
    

public Trainer(){
}
/**
 * Gets the trainer's unique ID.
 * 
 * @return the trainer's ID as an int.
 */
    public int getTrainerID() {
        return id;
    }

/**
 * Sets the trainer's ID to the specified value.
 *
 * @param trainerID the ID to set for the trainer
 */
public void setTrainerID(int trainerID) {
    this.id = trainerID;
}

/**
 * Retrieves the number of badges the trainer has earned.
 *
 * @return the number of badges
 */
public int getBadges() {
    return badges;
}

    
}


