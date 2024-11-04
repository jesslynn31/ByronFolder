import java.util.ArrayList;
public class ProfessorsResearch extends Trainer {


/**
 * Constructs an Professor's research object with the specified name.
 * 
 * @param name The name to assign to the trainer card (Professor's research)
 */

    public ProfessorsResearch() {
        setName("ProfessorsResearch");
    }


/**
 * Simulates the trainer Professor's research's actions:
 * - Moves all cards from the current hand to the discard pile.
 * - Resets the hand to an empty state.
 * - Adds new cards to the hand from the deck.
 *
 * @param deck The CardGame deck object
 */
    public void playWith(CardGame deck, ArrayList<Card> hand){
        deck.getDiscardHand().addAll(hand);
        hand.clear();
        deck.drawHand();


        
    }
    
}
