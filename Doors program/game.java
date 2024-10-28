
import java.util.ArrayList;
import java.util.Random; 

public class game {

    private ArrayList<Integer> doors;
   

    Random random = new Random(); 

/**
 * the game constructer, making the doors ArrayList and populating it by calling the doorslist method.
 */
    public game(){
        doors = new ArrayList<>();
        doorslist(); 
    }

/**
 * Populates the doors list with three door numbers: 1, 2, and 3.
 */

    public void doorslist(){

        doors.add(1);
        doors.add(2);
        doors.add(3);

        }
        
        

/**
 * Simulates a game scenario over 10000 trials to calculate the percentage of winning outcomes.
 * In each trial, the player selects one specific door, and a random door is the prize door.
 * If the player's choice matches the prize door, it counts as a win.
 *
 * @return The percentage of trials in which the player wins
 */

    public double gameOne() {

        int win = 0;
        int trials = 10000;


        for (int i = 0; i < trials; i++) {
            int player = doors.get(1);
            int prize = doors.get(random.nextInt(doors.size())); 

            if (player == prize) {
                win++;
            } 

                }

                double percentage = ((double) win / trials) * 100;
                return percentage;


    }


/**
 * a different game scenario over a 10000 trials to calculate the percentage of winning outcomes.
 * In each trial, the player's choice and prize door is random. The game host then opens a door.
 * The player then switches their choice to the remaining door if they did not guess the right door.
 * If the player's final choice matches the prize door, it counts as a win.
 *
 * @return The percentage of trials in which the player wins 
 */

    public double gameTwo(){

        int win = 0;
        int trials = 10000;

        for (int i = 0; i < trials; i++) {
            int player = doors.get(random.nextInt(doors.size())); 
            int prize  = doors.get(random.nextInt(doors.size())); 
           

            int open = -1;
            for (int door : doors) {
                if (door != player && door != prize) {
                    open = door;
                    break;
                }
            }

           
            for (int door : doors) {
                if (door != player && door != open) {
                    player = door;
                    break;
                }
            }

    
            if (player == prize) {
                win++;
            }
        }
        

        double result = ((double)win / trials) * 100;
        return result; 
    }
}


       






