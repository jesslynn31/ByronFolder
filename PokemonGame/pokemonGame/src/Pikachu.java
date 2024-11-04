public class Pikachu extends Pokemon {

    /**
     * Constructs a new Pikachu with its name and HP
     */
    public Pikachu() {
        setName("pikachu");
        setHp(60);
    }

    /**
     * does a quick attack on the specified enemy.
     * This attack reduces the enemy's HP by 10.
     *
     * @param target The Attackable entity that will receive the attack.
     */
    public void quickAttack(Attackable target) {
        int currentHp = target.getHp();
        int resultingHp = currentHp - 10;
        target.setHp(resultingHp);
        System.out.println("Pikachu used Quick attack!");
        System.out.println("target's HP is now: " + target.getHp());
    }

@Override
public void attack(Attackable target) {
   
    quickAttack(target);
}

@Override
public String toString() {
    return getName(); 
}
}

 
