import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class CardGame extends Player
{
    private Random rng;
    private Player player1;
    private Player player2;
    private Energy energy;
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> prizePile;
    private ArrayList<Card> discardPile;

    
    public CardGame(){
        super("cardgameplayer", null);
        deck = new ArrayList<>();
        hand = new ArrayList<>();
        rng = new Random();
        prizePile = new ArrayList<>();
        discardPile = new ArrayList<>();
        
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scan.nextLine();
        player1 = new Player(name, this);

        player2 = new Player("Player 2", this);

        this.energy = new Energy();
     

         
        

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

/**
 *  gets the hand of a player
 * @return the hand
 */
    public ArrayList<Card> getHand() {
        return hand;
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
    
    /**
     * Removes all of the cards from the hand
     */
    public void discardHand(){
        while(hand.size() != 0){
            deck.add(hand.remove(0));
        }
    }
    
    /**
     * Checks if the card is an Energy card
     * @return {true} if energy card, {false} if not
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

/**
 * Retrieves the current instance of the random number maker (RNG).
 *
 * @return the RNG instance used for random numbers.
 */

public Random getRng() {
    return rng;
}

    /*
     * Resets deck...
     */
    public void resetDeck() {
        deck = new ArrayList<>();

   }
   public void shuffleDeck(){

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

  
    public ArrayList<Card> getDiscardHand() {
        return discardPile;
    }

/**
 * carries out the actions for Player 2 (the computer) during their turn in the game.
 * <p>
 * This method makes Player 2 draw a card and attack back
 * Player 1's active Pokémon. If Player 2 has an active Pokémon that is 
 * capable of attacking, it will attempt to attack the active Pokémon of Player 1.
 * If Player 2 has no active Pokémon or if the active Pokémon cannot attack, 
 * certain messages will be printed to the console to tell them to fix it.
 * </p>
 *
 * @param player1 The first player, whose active Pokémon may be attacked.
 * @param player2 The second player, who is taking their turn.
 */
private void computerAction(Player player1, Player player2) {
    System.out.println("Player 2's turn.");
    player2.drawCard();
    System.out.println("player 2 drew a " + player2.getDeck().get(0));

    if (player2.getActivePokemon() != null) {
        if (player2.getActivePokemon() instanceof Attackable) {
            Pokemon target = player1.getActivePokemon();
            if (target != null) {
                ((Attackable) player2.getActivePokemon()).attack(target);
            } else {
                System.out.println(player2.getName() + " has no active Pokémon to attack.");
            }
        } else {
            System.out.println(player2.getName() + "'s active Pokémon cannot attack.");
        }
    }


}

private void takeTurn(Player player1, Player player2) {

    
    player1.fillDeck();
    player2.fillDeck();
    player1.drawHand();
    player2.drawHand();
    
    

    while (player1.getDeck().size() > 0 && player2.getDeck().size() > 0) {
        Scanner scan = new Scanner(System.in);
        System.out.println("hello! " + player1.getName());
        System.out.println("you must choose an active pokemon to add energy, use trainers, or attack.");
        System.out.println("Which option would you like to pick? 0: Show hand, 1: Draw a card, 2: Pick an active Pokémon, 3: Attack, 4: Add energy card, 5: use a trainer, 6: discard a card, 7. End Turn");
    
        int action = scan.nextInt();
        
        boolean endTurn = false;
        
        while (!endTurn) {
        switch (action) {
            case 0:
                System.out.println(player1.getName() + " chooses to show hand.");
                player1.showHand();
                endTurn = true;
                break;
           
    
            case 1:
                System.out.println(player1.getName() + " chooses to draw a card.");
                System.out.println("the card drawn is: " + player1.getDeck().get(0));
                player1.drawCard();
                endTurn = true;
                break;
    
            case 2:
                player1.showHand();
                System.out.println("Which Pokémon would you like to choose? 1: Eevee, 2: Pikachu, 3: Bulbasaur, 4. Jigglypuff.");
            
                int chosenPokemon = scan.nextInt();
                if (chosenPokemon == 1) {
                    player1.setActivePokemon(new Eevee());
                    System.out.println(player1.getName() + " chose Eevee.");
                    endTurn = true;
                    player2.setActivePokemon(new Pikachu());
                } else if (chosenPokemon == 2) {
                    player1.setActivePokemon(new Pikachu());
                    System.out.println(player1.getName() + " chose Pikachu.");
                    endTurn = true;
                    player2.setActivePokemon(new Eevee());
                } else if (chosenPokemon == 3) {
                    System.out.println(player1.getName() + " chose Bulbasaur.");
                    player2.setActivePokemon(new Eevee());
                    endTurn = true;
                } else if (chosenPokemon == 4) {
                    System.out.println(player1.getName() + " chose Jigglypuff.");
                    player2.setActivePokemon(new Bulbasaur());
                    endTurn = true;
                }
                 else {
                    System.out.println("Invalid choice. Please select again.");
                }
                break;
               
    
            case 3:
            if (player1.getActivePokemon() != null) {
                if (player1.getActivePokemon() instanceof Attackable) {
                    Pokemon target = player2.getActivePokemon();
                    if (target != null) {
                        ((Attackable) player1.getActivePokemon()).attack(target);
                    } else {
                        System.out.println(player2.getName() + " has no active Pokémon to attack.");
                    }
                } else {
                    System.out.println(player1.getName() + "'s active Pokémon cannot attack.");
                }
            } else {
                System.out.println(player1.getName() + " has no active Pokémon to attack with.");
            }
            endTurn = true;
            break;
            case 4:
            System.out.println("Which energy card do you want? 1: fire, 2: water, 3: grass, 4: basic");
            int chosenEnergy = scan.nextInt();
            if (chosenEnergy == 1) {
                player1.attachEnergy(new fire());
                System.out.println("You added a fire card!");
                endTurn = true;
            } else if (chosenEnergy == 2) {
                player1.attachEnergy(new Water());
                System.out.println("You added a water card!");
                
            } else if (chosenEnergy == 3) {
                player1.attachEnergy(new Grass());
                System.out.println("You added a grass card!");
                endTurn = true;
            } else if (chosenEnergy == 4) {
                player1.attachEnergy(new Basic());
                System.out.println("You added a basic card!");
                endTurn = true;
            }else {
                System.out.println("Not a valid choice. choose again.");
            }
            break;
            

                case 5:
                System.out.println("Which trainer would you like to use? 1: Youngester, 2: Professor's Research");
                int chosenTrainer = scan.nextInt();
            
                if (chosenTrainer == 1) {
                    Youngster youngster = new Youngster();
                    youngster.playWithYoungester(this, player1.getDeck());
                    System.out.println("You have used Youngster!");
                    endTurn = true;
                } else if (chosenTrainer == 2) {
                    ProfessorsResearch professorResearch = new ProfessorsResearch();
                    professorResearch.playWith(this, player1.getDeck());
                    System.out.println("You have used Professor's Research!");
                    endTurn = true;
                } else if (chosenTrainer == 3) {
                    misterTrainer mister = new misterTrainer();
                    mister.playWithMisterTrainer(player1);
                    player1.discardHand();
                    System.out.println("You have used Mister Trainer!");
                    endTurn = true;
                } else {
                    System.out.println("Not a valid choice. Please choose again.");
                }
                break;
            case 6:
                player1.discardCard();

            case 7:
                endTurn = true;
                break;
    
            default:
                System.out.println("Invalid action. Please choose again.");
                break;
        }
    }
    computerAction(player1, player2);
}
}


public void run(){

takeTurn(player1, player2);

    
}
}



    

    


    

