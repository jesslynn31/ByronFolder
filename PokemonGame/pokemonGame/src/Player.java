import java.util.ArrayList;
import java.util.Random;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private ArrayList<Card> deck;
    private CardGame cardGame;
    private ArrayList<Card> prizePile;
    private ArrayList<Pokemon> pokemonList;
    private ArrayList<Trainer> trainerList;
    private ArrayList<Energy> energyList;
    private Pokemon activePokemon;
    private Random rng;
    private ArrayList<Card> discardPile;

    



public Player(String name, CardGame cardGame) {
    this.name = name;
    this.hand = new ArrayList<>();
    this.deck = new ArrayList<>();
    this.pokemonList = new ArrayList<>();
    this.prizePile = new ArrayList<>();
    this.discardPile = new ArrayList<>();
    energyList = new ArrayList<>();
    pokemonList = new ArrayList<>();
    trainerList = new ArrayList<>();
    this.cardGame = cardGame;
    rng = new Random();

}

/**
 * gets the discard pile containing cards that have been discarded.
 *
 * @return the discard pile as an ArrayList of cards
 */
public ArrayList<Card> getDiscardPile() {
    return discardPile;
}
/**
 * removes all cards from the player's hand by moving them to the deck.
 * This method removes each card from the hand and adds it to the deck
 * until the hand is empty.
 */
public void discardHand() {
    while(hand.size() != 0) {
        deck.add(hand.remove(0));
    }
}
/**
 * Discards a card from the player's hand by moving it to the discard pile.
 * It makes sure the hand isn't empty, then removes the card and it
 * adds it to the discard pile, and prints a message showing the discarded card.
 */
public void discardCard() {
    if (!hand.isEmpty()) {
        discardPile.add(hand.remove(0));
        System.out.println("You discarded your card!" + discardPile);
    }
}

/**
 * Attaches an Energy card from the player's hand to the active Pokemon
 * If there is an active pokemon and energy card in the hand,
 * this method removes the first Energy card found from the hand, attaches it
 * to the active Pokémon, and prints a message indicating the attachment.
 *
 * @param Energy card to attach)
 */
public void attachEnergy(Energy energy) {
    if (activePokemon != null) {
        for (Card card : hand) {
            if (card instanceof Energy) {
                activePokemon.attachEnergy((Energy) card);
                hand.remove(card);
                System.out.println("Attached an energy card to " + activePokemon.getName());
                
                return;
            }
        }
    }
}


/**
 * Resets the deck by creating a new, list for the deck.
 */
public void resetDeck() {
    deck = new ArrayList<>();
}

/**
 * Resets the hand by creating a new, empty list for the hand.
 */
public void resetHand() {
    hand = new ArrayList<>();
}

/**
 * Draws two random cards from the deck and adds them to the hand.
 */
public void drawCard() {
    for (int i = 0; i < 2; i++) {
        int drawIndex = rng.nextInt(deck.size()); 
        hand.add(deck.get(drawIndex));
        deck.remove(drawIndex);
    }
}
/**
 * Draws six random cards from the deck and adds them to the prize pile.
 */
public void drawPrizePile(){
    for (int i = 0; i > 6; i++){
        int drawIndex = rng.nextInt(hand.size());
        prizePile.add(deck.get(drawIndex));
    }
}

/**
 * Picks a random Pokémon card from the player's hand.
 *
 * @return A random Pokémon card from the hand, or nothing
 */
public Pokemon pickRandomPokemon() {
    ArrayList<Pokemon> pokemonInHand = new ArrayList<>();
    
    for (Card card : hand) {
        if (card instanceof Pokemon) {
            pokemonInHand.add((Pokemon) card);
        }
    }

    if (pokemonInHand.isEmpty()) {
        return null;
    }

    int randomIndex = (int) (Math.random() * pokemonInHand.size());
    return pokemonInHand.get(randomIndex);
}

/**
 * gets the list of pokemon
 * @return the list of pokemon
 */
public ArrayList<Pokemon> getPokemonList() {
    return pokemonList;
}

/**
 * shows the hand of the player
 */
public void showHand() {
    System.out.println("Player " + name + "'s hand:");
    for (Card card : hand) {
        System.out.println(card);
    }
}

/**
 * Gets the active Pokemon.
 * @return activePokemon
 */
public Pokemon getActivePokemon(){
    return activePokemon;
}

/**
 * sets the active pokemon
 * @param activePokemon
 */
public void setActivePokemon(Pokemon activePokemon) {
    this.activePokemon = activePokemon;
}

/**
 * Gets the current hand of the player.
 *
 * @return An ArrayList containing the cards in the player's hand.
 */
public ArrayList<Card> handed() {
    return cardGame.getHand();  
}

/**
 * Gets the name of the player.
 *
 * @return The name of the player as a String.
 */
public String getName() {
    return name;
}


/**
 * Creates a deck for the player
 * It adds 20 random Pokemon cards, 20 random Energy cards and 20 trainer cards.
 * The total is 60 cards.
 */
public void fillDeck(){


    for(int i = 0; i < 20; i++){
        deck.add(randomPokemon());
    }
    for(int i = 0; i < 20; i++){
        deck.add(randomEnergy());
    }

    for(int i = 0; i < 20; i++){
        deck.add(randomTrainer());
    }

}

/**
 * Generates a random Pokemon card, either Pikachu, Bulbasaur, Eevee, or jigglyPuff.
 * @return A random Pokemon card.
 * 
 */
public Pokemon randomPokemon(){
    Random rand = new Random();
    pokemonList.add(new Pikachu());
    pokemonList.add(new Bulbasaur());
    pokemonList.add(new Eevee());
    pokemonList.add(new JigglyPuff());
    return pokemonList.get(rand.nextInt(pokemonList.size()));
}

/**
 * Generates a random Energy card, either fire, grass, basic, or water.
 * @return A random Energy card.
 */
public Energy randomEnergy(){
    Random rand = new Random();
    energyList.add(new fire());
    energyList.add(new Grass());
    energyList.add(new Basic());
    energyList.add(new Water());
    return energyList.get(rand.nextInt(energyList.size()));
}

/**
 * Generates a random Trainer card, either ProfessorsResearch or Youngster.
 * @return A random trainer card.
 */
public Trainer randomTrainer(){
    Random rand = new Random();
    trainerList.add(new ProfessorsResearch());
    trainerList.add(new Youngster());
    return trainerList.get(rand.nextInt(trainerList.size()));
}

/**
 * Gets the deck of the player.
 * @return the deck of the player
 */
public ArrayList<Card> getDeck() {
    return deck;
}

/**
 * Gets the deck size
 * @return the size of the deck
 */
public int getDeckSize() {
    return deck.size();
}


/**
 * Draws 7 cards from the deck and adds them to the player's hand.
 * This method assumes the deck has enough cards to draw from.
 */
public void drawHand() {
    for (int i = 0; i < 7; i++) {
        if (!deck.isEmpty()) {
            int drawIndex = cardGame.getRng().nextInt(deck.size());
            hand.add(deck.get(drawIndex));
            deck.remove(drawIndex);
        }
    }
}
}