import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Scanner;



public class CardGame
{
    private Random rng;
    private Player player1;
    private Player player2;
    private Energy energy;
    private Card card;
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> prizePile;
    private ArrayList<Card> discardHand;
    
    public CardGame(){
        deck = new ArrayList<>();
        hand = new ArrayList<>();
        rng = new Random();
        prizePile = new ArrayList<>();
        this.player1 = new Player("Player 1", this);
        this.player2 = new Player("Player 2", this);
        this.energy = new Energy();
        this.card = new Card();
        energy.setEnergy(5);
        

    }

    
    public void fillDeck(){
        for(int i = 0; i < 55; i++){
            deck.add(new Energy());
        }
        for(int i = 0; i < 5; i++){
            deck.add(new Pokemon());
        }

        for(int i = 0; i < 2; i++){
            deck.add(new Trainer());
        }

    }


    
    /** 
     * @return the deck 
     */
    public ArrayList<Card> getDeck() {
        return deck;
    }

/**
 * moves a 'random' pokemon card from the deck into the player's hand
 * 
 */
    public void drawCard() {
        for (int i = 0; i < 2; i++){
            int drawIndex = rng.nextInt(hand.size());
            hand.add(deck.get(drawIndex));
            deck.remove(drawIndex);
        }
         }



    
    
    /** 
     * @return prize pile 
     */
    public ArrayList<Card> getPrizePile() {
        return prizePile;
    }

    public void discardPrizePile(){
        prizePile = new ArrayList<>();
    }

    public ArrayList<Card> getDiscardHand() {
        return discardHand;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

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
    
    public void drawHand(){
        for (int i = 0; i < 7; i++){
            int drawIndex = rng.nextInt(deck.size());
            hand.add(deck.get(drawIndex));
            deck.remove(drawIndex);
        }
    }
    
    /*
     * Removes all of the cards from the hand
     */
    public void discardHand(){
        while(hand.size() != 0){
            deck.add(hand.remove(0));
        }
    }
    
    /*
     * Checks if the card is an Energy card
     */
    public void isEnergyCard(){
    boolean hasEnergyCard = false;
    for (Card card : hand) {
        if (card instanceof Energy) {
            hasEnergyCard = true;
            energy.refuelEnergy();
        }
    }
}
public Random getRng() {
    return rng;
}
    /*
     * Resets deck...
     */
    public void resetDeck() {
        deck = new ArrayList<>();

   }


   /*
    * Resets hand...
    */
       public void resetHand(){
          hand = new ArrayList<>();
       }

    /*
     * Checks if the hand has a pokemon to be valid ( cant play without pokemon,)
     */
    public boolean isHandValid(){
        for (Card c : hand){
            if (c instanceof Pokemon){
                return true;
            }
        }
        
        return false;
    }

    /* 
     * Add a new group of cards into the hand
     */
    public void AddCards(){
        hand.add(deck.remove(rng.nextInt(deck.size())));
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

    public void newDeck(){
        resetDeck();
        resetHand();
       

        for(int i = 1; i <= 15; i++) {
            deck.add(new Pokemon());
        }
        
        for(int i = 0; i <= 15; i++) {
            deck.add(new Energy());
        }

        for(int i = 0; i <= 30; i++){
            deck.add(new Trainer());
        }

    }



public void RareCandyDeck(int rareCandyCount){

    resetDeck();
    resetHand();
    
    int pokemonCount = 60 - rareCandyCount;

    for (int i = 0; i <= rareCandyCount; i++) {
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
       
    for (int i = 1; i < 8; i++){

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

private int determineAction(Player player2) {
    int randomAction = (int) (Math.random() * 5);
    return randomAction;
}

private void takeTurn(Player player1, Player player2) {
    System.out.println(player1.getName() + "'s turn!");

    int action = determineAction(player1); 

    switch (action) {
        case 0:
            System.out.println(player1.getName() + " chooses to show hand.");
            player1.showHand();
            break;

        case 1:
            System.out.println(player1.getName() + " chooses to draw a card.");
            player1.drawCard();
            break;

        case 2:
            System.out.println(player1.getName() + " chooses to attack.");
            evaluateOpeningHand();
            if (player1.getActivePokemon() != null) {
                player1.attack(player2);
            } else {
                System.out.println(player1.getName() + " has no active Pokémon to attack with.");
            }
            break;

        case 3:
            System.out.println(player1.getName() + " chooses to add an energy card.");
            player1.attachEnergy(); 
            break;

        case 4:
            System.out.println(player1.getName() + " chooses to draw a new hand.");
            player1.drawHand();
            break;

        default:
            System.out.println(player1.getName() + " skips the turn.");
            break;
    }
}

public void run(){



    
}
}



    

    


    

