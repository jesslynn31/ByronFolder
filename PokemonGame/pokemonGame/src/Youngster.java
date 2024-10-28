public class Youngster extends Trainer {
    

/**
 * Constructs an Professor's research object with the specified name.
 * 
 * @param name The name to assign to the trainer card (Professor's research)
 */

 public Youngester(String name) {
    setName("Youngester");
}

/**
 * the trainer's abilities are defined here
 * 
 * @param deck the deck to discard the hand and draw the hand into
 */
public void playWithYoungester(CardGame deck){

    deck.discardHand();
    deck.drawHand();
    
}
}
