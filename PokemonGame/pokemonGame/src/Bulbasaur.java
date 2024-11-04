
public class Bulbasaur extends Pokemon  {
    
/**
 * Constructs an Bulbasaur object with the specified name.
 * 
 * @param name The name to assign to pokemon (Bulbasaur)
 */

    public Bulbasaur() {
        setName("Bulbasaur");
        setHp(70);
    }
     
/**
 * does a Leech Seed attack on a enemy, draining 20 HP from it
 * and giving it to this entity. If the target's HP is reduced by 20, 
 * this pokemon's HP increases by 20.
 *
 * @param target the enemy to be attacked, which implements the Attackable interface.
 */
public void leechseed(Attackable target) {
    int currentHp = target.getHp();
    int resultingHp = currentHp - 20; 

    int thisCurrentHp = this.getHp();
    this.setHp(thisCurrentHp + 20);

    target.setHp(resultingHp);
}

    @Override
    public void attack(Attackable target) {
       
        leechseed(target);
    }

@Override
public String toString() {
    return getName(); 
}
   
} 
