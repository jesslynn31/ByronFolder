public class Pikachu extends Pokemon implements Attackable {

    public Pikachu(){
       setName("pikachu");
        setHp(60);
    }

public void quickAttack(Attackable target) {
    // Deal 10 damage
    int currentHp = target.getHp();
    int resultingHp = currentHp - 10;
    target.setHp(resultingHp);
}

public void electroBall(Attackable target) {
    //deal 60 dmg
    int currentHp = target.getHp();
    int resultingHp = currentHp - 60;
    target.setHp(resultingHp);
}

@Override
public void attack(Attackable target) {
   
    quickAttack(target);
}
}
 
