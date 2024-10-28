
public class distributionTypes {

    //binominal, geometric etc..
ComboPerm testComb = new ComboPerm();


/**
 * Computes the binomial distribution probability for a given number of trials and successes.
 *
 * <p>The binomial distribution represents the probability of achieving exactly 
 * x successes in a fixed number of trials (experiments with two possible outcomes
 * often known as "successes" and "failures"). This method calculates the probability
 * of obtaining x successes given the probability of success p and the number of trials
 * </p>
 * 
 * @param p      the probability of success on a trial 
 * @param trials the total amount of trials 
 * @param x      the number of successes to find the final probability
 * @return the probability of obtaining exactly x successes in the given number of trials
 */

public double computeBinomialDistribution(double p, int trials, int x){
    double combination = testComb.computeCombination(trials, x);

    return (combination * Math.pow(p, x)) * (Math.pow(1-p, trials - x));
}

/**
 * Computes the probability of success on the X-th trial by geometric distribution.
 *
 * <p>The geometric distribution finds the number of trials required for the first 
 * success in a series of trials with two possible outcomes. 
 * This method calculates the probability of achieving the first success on the X-th trial, 
 * given the probability of success p and the number of trials n.</p>
 *
 * @param p the probability of success on each trial
 * @param n the total amount of trials 
 * @param X the trial number at which the first success is considered 
 * @return the probability of achieving the first success on the Xth trial
 */

public double computeGeometricDistribution(double p, int n, int X){

    if (X == n) {
        return Math.pow(1 - p, n - 1) * p;
    } else if (X <= n) {
        return 1 - Math.pow(1 - p, n);
    }
    return 0;
}

}
    

