
public class Bulbasaur extends Pokemon implements Attackable {
    
    
    
/**
 * Constructs an Bulbasaur object with the specified name.
 * 
 * @param name The name to assign to pokemon (Bulbasaur)
 */

    public Bulbasaur(String name) {
        setName("Bulbasaur");
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
   
} 
