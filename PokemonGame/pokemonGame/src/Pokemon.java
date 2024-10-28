import java.util.ArrayList;

public class Pokemon extends Card implements Attackable {
    
    private int hp; 
    private ArrayList<Energy> attachedEnergy;
   

    public Pokemon() {
      this.attachedEnergy = new ArrayList<>(); 
    }

    public ArrayList<Energy> getAttachedEnergy() {
      return attachedEnergy;
  }
 

  public void attachEnergy(Energy energy) {
   if (attachedEnergy == null) {
       attachedEnergy = new ArrayList<>(); 
   }
    }



    public int getHp(){
 
     return hp;
    }

    public void setHp(int userInputHp){
     hp = userInputHp;
    }

    @Override
    public void attack(Attackable target) {
        System.out.println("Pokemon performs a basic attack!");
    }
}
 
 