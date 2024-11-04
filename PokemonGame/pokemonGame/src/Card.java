public class Card {

    private String name;
  
/**
 * Retrieves the card name.
 *
 * @return the name as a String.
 */

 public Card(){
    setName("");
 }

/**
 * Sets the card name to the specified value.
 *
 * @param name the name to set, represented as a String.
 */

public void setName(String name) {
    this.name = name;
}


/**
 * gets the name of the card.
 *
 * @return the name as a String
 */
public String getName(){
    return name;
}


@Override
public String toString() {
    return name; 
}

}

