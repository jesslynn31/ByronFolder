import java.util.ArrayList;


public class Conditional {
    
    // includes independence, dependence, conditional prob, and bayes.....


/**
 * Computes the conditional probability of event A given event B, which is P(A|B).
 * Assumes that P(A ∩ B) = P(A) * P(B), which is true if independent
 *
 * @param probabilityofA the probability of A (P(A))
 * @param probabilityofB the probability of B (P(B))
 * @return the conditional probability P(A|B) = P(A ∩ B) / P(B)
 */
    public double computeConditionalProbability(double probabilityofA, double probabilityofB){

        double PB = probabilityofB;
        double PA = probabilityofA;

        double PANB = PB * PA; 
    

        return (double) PANB / PB;



    }
/**
 * Computes the conditional probability P(A|B) using Bayes' Theorem.
 *
 * Bayes' Theorem is expressed as: P(A|B) = (P(B|A) * P(A)) / P(B),
 *
 * @param probabilityofA The prior probability of event A occurring.
 * @param probabilityofB The prior probability of event B occurring.
 * @return The conditional probability P(A|B).
 */
    public double computeBayesTheorem(double probabilityofA, double probabilityofB){

        double PB = probabilityofB;
        double PA = probabilityofA;
        double PANB = PB * PA; 

        double BA = PANB / PB;

        return (double) PA * BA / PB;
    }


/**
 * Determines whether two events A and B are independent based on their probabilities.
 *
 * Two events A and B are considered independent if any of the following conditions hold:
 * @param probabilityA The probability of event A occurring.
 * @param probabilityB The probability of event B occurring.
 * @param probabilityANB The joint probability of both events A and B occurring.
 * @return {true} if the events are independent; {false} if they are dependent.
 */

    public boolean isIndependent(double probabilityA, double probabilityB, double probabilityANB){

    if (probabilityA * probabilityA == probabilityANB) {
        System.out.println("Independent");
        return true;
    }
    if (computeConditionalProbability(probabilityA, probabilityB) == probabilityA) {
        System.out.println("Independent");
        return true;
    }
    if (computeBayesTheorem(probabilityA, probabilityB) == probabilityB) {
        System.out.println("Independent");
        return true;
    }
        System.out.println("Dependent");
        return false;
    }


}

