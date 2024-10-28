import java.util.Random;

public class birthday {


    Random random = new Random();
    
/**
 * does the birthday problem by calculating the probability 
 * that at least two people in a group share the same birthday 
 * over a specified number of trials.
 *
 * @param trials  the number of simulations 
 * @param people  the number of people in each simulation
 * @return  the probability that at least two people share the same birthday
 */
public double calculateSameBday(int trials, int people) {
    int same_birthday = 0;

    for (int i = 0; i < trials; i++) { 
        int[] birthdays = new int[people];

        for (int j = 0; j < people; j++) {
            birthdays[j] = random.nextInt(365) + 1;
        }

        boolean sameBirthday = false;
        for (int j = 0; j < people; j++) {
            for (int k = j + 1; k < people; k++) {
                if (birthdays[j] == birthdays[k]) {
                    sameBirthday = true; 
                    break;  
                }
            }
            if (sameBirthday) {
                same_birthday++; 
                break;  
            }
        }
    }
    double answer = (double) same_birthday / trials; 
    return answer; 
}
  
   
}
   //public static int expectedOutcome() {

   

     //expected outcome
   //  int math = (people * people - 1) / (people * trials * trials);

   

   
   //return math;



