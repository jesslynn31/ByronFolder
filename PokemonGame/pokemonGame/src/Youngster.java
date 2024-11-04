import java.util.ArrayList;

public class Youngster extends Trainer {
    

/**
 * Constructs an Professor's research object with the specified name.
 * 
 * @param name The name to assign to the trainer card (Professor's research)
 */

 public Youngster() {
    setName("Youngster");
}

/**
 * the trainer's abilities are defined here
 * 
 * @param deck the deck to discard the hand and draw the hand into
 */
public void playWithYoungester(CardGame deck, ArrayList<Card> hand){

    deck.discardHand();
    deck.drawHand();
    System.out.println("Youngster played!");
    System.out.println("your new hand is: " + deck.getHand());
    
}
}
