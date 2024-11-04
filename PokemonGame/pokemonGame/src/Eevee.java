
import java.util.Random;


public class Eevee extends Pokemon {

    // this isn't 100% accurate but why are there 39439439 eevee cards?
    
/**
 * Constructs an Eevee object with the specified name.
 * 
 * @param name The name to assign to the Pokemon (Eevee). 
 */

    public Eevee() {
        setName("Eevee");
        setHp(70);
    }

/**
* Performs a lunge attack on a certain enemy.
* The enemy loses 20 HP, and Eevee gains 20 HP.
*
* @param target The Attackable Pokémon that is targeted by the lunge attack.
*/

    public void lunge(Attackable target){
        int currentHp = target.getHp();
        int resultingHp = currentHp - 20; 

        int thisCurrentHp = this.getHp();
        this.setHp(thisCurrentHp + 20);

        target.setHp(resultingHp);
    }




/**
 * performs a chargeup attack on a certain enemy based on a flip of a coin. 
 * If it lands on heads, Eevee does 30 damage, if not, she does nothing.
 * 
 * @param target The attackable Pokemon that is targeted by the chargeUp attack
 */
    public void chargeUp(Attackable target){
            String[] coin = {"heads", "tails"};
            Random random = new Random();
            String flipResult = coin[random.nextInt(2)]; 
        
            if (flipResult.equals("heads")) {
                int currentHp = target.getHp();
                int resultingHp = currentHp - 30;
                target.setHp(resultingHp);
            }
            System.out.println("Eevee used Charge Up!");
            System.out.println("target's HP is now: " + target.getHp());

        
    }

    
    @Override
    public void attack(Attackable target) {
       
        chargeUp(target);
    }
@Override
    public String toString() {
      return getName(); 
    }
   
} 

