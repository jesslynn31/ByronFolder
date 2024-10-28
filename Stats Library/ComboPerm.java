

public class ComboPerm {
    
// a class that consists of combinations, permutations and factorials! fun!


/**
 * gives the number of combinations (n choose r) 
 *
 * <p>This method calculates the number of ways to choose r items from a set of n items
 * without caring about order, the formula is:
 * nCr = n! / (r! * (n - r)!).
 *
 * @param n the total number of items 
 * @param r the number of items to choose 
 * @return the combination answer 
 */
public double computeCombination(int n, int r){


double combination = (double) computeFactorial(n) / (computeFactorial(n-r) * computeFactorial(r));


return combination;

}

/**
 * Computes the number of permutations 
 *
 * <p>This method calculates the number of ways to arrange r items out of how many n there are
 * order matters here, the formula is: 
 * nPr = n! / (n - r)!.
 *
 * @param n the total number of items 
 * @param r the number of items that are being arranged
 * @return the permutation answer 
 */

public double computePermutation(int n, int r){

    double permutation = (double) computeFactorial(n) / (computeFactorial(n-r));

    return permutation;

}


/**
 * Computes the factorial of a positive integer.
 *
 * <p>The factorial of a positive integer n is the product of integers
 * less than or equal to n. It is defined by n! </p>
 *
 * @param num the positive integer inputted
 * @return the factorial of the given integer inputted
 */

public int computeFactorial(int num){

   int factorial = 1;
    
    for (int i=1; i <= num; i++){

     factorial*= i;

    }

    return factorial;
}

}
