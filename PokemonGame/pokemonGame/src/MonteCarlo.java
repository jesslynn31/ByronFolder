import java.util.ArrayList;
import java.util.Random;

public class MonteCarlo {

    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> prizePile;
    private Random rng;

    MonteCarlo(){
        deck = new ArrayList<>();
        hand = new ArrayList<>();
        prizePile = new ArrayList<>();
        rng = new Random();
    }

    public void resetDeck() {
        deck = new ArrayList<>();

   }

   public void discardHand(){
    while(hand.size() != 0){
        deck.add(hand.remove(0));
    }
}
   public void resetHand(){
         hand = new ArrayList<>();
   }
    public void discardPrizePile(){
        prizePile = new ArrayList<>();
    }

     /**
     * draws a random hand of cards from the deck
     */
    public void drawHand(){
        for (int i = 0; i < 7; i++){
            int drawIndex = rng.nextInt(deck.size());
            hand.add(deck.get(drawIndex));
            deck.remove(drawIndex);
        }
    }

    public boolean isHandValid(){
        for (Card c : hand){
            if (c instanceof Pokemon){
                return true;
            }
        }
        return false;
        }
/**
 * Evaluates the opening hand to check if it contains at least one Pokémon card.
 * 
 * @return {true} if a Pokémon card is found in the hand, {false} otherwise.
 */
    public boolean evaluateOpeningHand(){
        boolean havePokemon = false;

        for(int i = 0; i < hand.size(); i++){
            Card currentCard = hand.get(i);

            if(currentCard instanceof Pokemon){ 
                return true;
            }
        }
        return havePokemon;
            }

public void RareCandyDeck(int rareCandyCount){

        resetDeck();
        resetHand();
        
        int pokemonCount = 60 - rareCandyCount;
    
        for (int i = 0; i < rareCandyCount; i++) {
            deck.add(new RareCandy());
        }
    
        for (int i = 0; i < pokemonCount; i++) {
            deck.add(new Pokemon());
        }
        
    }

/**
 * Simulates the probability of having a "bricked" hand in a Pokémon card game,
 * where a "bricked" hand is defined as having all specified Rare Candy cards
 * in the prize pile during the initial setup of the game.
 *
 * @param trials The number of trials to simulate for each count of Rare Candy cards 
 *               (from 1 to 7). A higher number of trials will provide a more accurate
 *               probability estimate.
 */
public void rareCandySimulator(int trials){

    int bricked;
       
    for (int i = 1; i < 5; i++){

        bricked = 0;

        for (int j = 0; j < trials; j++){
            
            discardPrizePile();

            RareCandyDeck(i);
            drawHand();

            while (!isHandValid()) {
                discardHand();
                drawHand();
            }

                
            for(int c = 0; c < 7; c++){
                prizePile.add(deck.remove(rng.nextInt(deck.size())));
            }

            int candiesinPrizePile = 0;
            for (Card card : prizePile) {
                if (card instanceof RareCandy) {
                    candiesinPrizePile++;
                }
            }
            
            if (candiesinPrizePile == i) {
                bricked++;
            }           
        }
        double probability =  (double) bricked / trials * 100;
        System.out.println(bricked + "/" + trials);
        System.out.println("The probability for " + i + " candies is:" + probability); 
    }            
}


    /*
     * Pokemon deck used for the monte carlo below
     * 
     * @param pokemonCount the amount of pokemon in the deck 
     */
    public void newDeckMultiplePokemon(int pokemonCount) {
        
        resetDeck();
        resetHand();
        int newDeckSize = 60;


        for(int i = 1; i <= pokemonCount; i++) {
            deck.add(new Pokemon());
        }
        
        for(int i = pokemonCount; i <= newDeckSize; i++) {
            deck.add(new Energy());
        }
    }
     
/*
 * This method finds the probability of having a pokemon in the opening hand
 * based on how many pokemon and trials using the newDeckMultiplePokemon deck.
 */
public void monteCarlo(){
    
    for (int i = 0; i < 61; i++){
        int count = 0;
        newDeckMultiplePokemon(i);
        
        for(int j = 0; j < 10000; j++){
            resetHand();
            drawHand();
            
            if (evaluateOpeningHand()) {
                count++;
                    
        }
        newDeckMultiplePokemon(i+1);
      
        
    
    }
    double calculation = (double) count / 10000 * 100;
    System.out.println(calculation + "%");
}
}
        
}
    

