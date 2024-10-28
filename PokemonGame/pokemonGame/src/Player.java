import java.util.ArrayList;
import java.util.Random;

public class Player extends CardGame {

    private String name;
    private ArrayList<Card> hand;
    private ArrayList<Card> deck;
    private CardGame cardGame;
    private ArrayList<Pokemon> pokemonList;
    private int activePokemonIndex;
    private Energy energy;



public Player(String name, CardGame cardGame) {
    this.cardGame = cardGame;  
    this.hand = new ArrayList<>();
    this.deck = new ArrayList<>();
    this.pokemonList = new ArrayList<>();
    this.activePokemonIndex = -1;
    this.energy = energy;
    this.pokemon = pokemon.

}


public Pokemon pickRandomPokemon() {
    ArrayList<Pokemon> pokemonInHand = new ArrayList<>();
    for (Card card : hand) {
        if (card instanceof Pokemon) {
            pokemonInHand.add((Pokemon) card);
        }

      
    }
    int randomIndex = (int) (Math.random() * pokemonInHand.size());
    return pokemonInHand.get(randomIndex);
}

 public ArrayList<Card> handed() {
    return cardGame.getHand();  
}

public String getName(){
    return name;
}

public void drawHand(){
    for (int i = 0; i < 7; i++){
        int drawIndex = cardGame.getRng().nextInt(deck.size());
        hand.add(deck.get(drawIndex));
        deck.remove(drawIndex);
    }
}

public void drawCard() {
    for (int i = 0; i < 2; i++){
        
        int drawIndex = cardGame.getRng().nextInt(hand.size());
        hand.add(deck.get(drawIndex));
        deck.remove(drawIndex);
    }
     }

public boolean isHandValid() {
    for (Card card : hand) {
        if (card instanceof Pokemon) {
            return true; 
        }
    }
    return false;
}

public boolean isEnergyCard(){
    boolean hasEnergyCard = false;
    for (Card card : hand) {
        if (card instanceof Energy) {
            hasEnergyCard = true;
            energy.refuelEnergy();
        }
    }
    return hasEnergyCard;
}
 public void showHand() {
    System.out.println("Player's hand:");
    for (Card card : cardGame.getHand()) {
        System.out.println(card.getName());
    }

}

public void addPokemon(Pokemon pokemon) {
    pokemonList.add(pokemon);
}

public void setActivePokemon(int index) {
    if (index >= 0 && index < pokemonList.size()) {
        activePokemonIndex = index;
    }
}

    public Pokemon getActivePokemon() {
        if (activePokemonIndex >= 0) {
            return pokemonList.get(activePokemonIndex);
        }
        else {
            return null;
        }
    }

    

public void attack(Player target) {

    Attackable attacker = this.getActivePokemon();
    Attackable defender = target.getActivePokemon();

    if (attacker instanceof Pikachu) {
        Random random = new Random();
        int attackChoice = random.nextInt(2);
        
        if (attackChoice == 0) {
            System.out.println(name + " uses Electro Ball!");
            ((Pikachu) attacker).electroBall(defender); 
        } else {
            System.out.println(name + " uses Quick Attack!");
            ((Pikachu) attacker).quickAttack(defender); 
        }
}
}
}
