import java.util.ArrayList;

public class Pokemon extends Card implements Attackable {
    
    private int hp; 
    private ArrayList<Energy> attachedEnergy;
   

/**
 * Constructor for the Pokemon class. 
 * makes an empty list to hold attached energy cards.
 */
public Pokemon() {
    this.attachedEnergy = new ArrayList<>(); 
   
}

/**
 * Attaches an energy card to a pokemon. 
 * If the list of attached energy cards is empty, it makes a new list.
 * 
 * @param energy the energy card to attach.
 */
public void attachEnergy(Energy energy) {
    if (attachedEnergy == null) {
        attachedEnergy = new ArrayList<>(); 
    }
    attachedEnergy.add(energy);
    System.out.println("Energy card attached to Pokemon!");
}

/**
 * gets the list of energy cards attached to this Pokémon.
 * 
 * @return an ArrayList of {Energy} objects currently attached.
 */
public ArrayList<Energy> getAttachedEnergy() {
    return attachedEnergy;
}



/**
 * Gets the current HP of this Pokémon.
 * 
 * @return the HP value as an integer.
 */
public int getHp() {
    return hp;
}

/**
 * Sets the current HP of this Pokémon.
 * 
 * @param userInputHp the HP value to set.
 */
public void setHp(int userInputHp) {
    hp = userInputHp;
}

@Override
public String toString() {
    return getName(); 
}

    @Override
    public void attack(Attackable target) {
        System.out.println("Pokemon performs a basic attack!");
    }
}
 
 