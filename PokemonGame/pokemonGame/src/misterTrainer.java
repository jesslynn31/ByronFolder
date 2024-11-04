public class misterTrainer extends Trainer {


/**
 * Constructs a mister trainer object with the specified name.
 * 
 * @param name The name to assign to the trainer card (mr trainer)
 */

 public misterTrainer() {
    setName("mister trainer");
}

public void playWithMisterTrainer(Player discardPile){

    discardPile.discardHand();
}

    
}
