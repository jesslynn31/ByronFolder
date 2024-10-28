public class jigglyPuff extends Pokemon implements Attackable {


    public jigglyPuff(String name) {
        setName("jifflyPuff");
    }

    public void rollOut(Attackable target){
        int currentHp = target.getHp();
        int resultingHp = currentHp - 10;
        target.setHp(resultingHp);
    }
    @Override
    public void attack(Attackable target) {
       
        rollOut(target);
    }

    
}

