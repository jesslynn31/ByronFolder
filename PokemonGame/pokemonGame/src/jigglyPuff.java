public class JigglyPuff extends Pokemon {


    public JigglyPuff() {
        setName("JigglyPuff");
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

