import java.util.ArrayList;
import java.util.Collections;


public class StatsLibraryTester {

public static void main(String[] args){
    MeanMedMode testMean = new MeanMedMode();
    ComboPerm testComb = new ComboPerm();
    SetOperations testOp = new SetOperations();
    Conditional testCon = new Conditional();
    distributionTypes testDis = new distributionTypes();


    
    ArrayList <Integer> listOfNumbers = new ArrayList<>();
   listOfNumbers.add(5);
   listOfNumbers.add(6);
   listOfNumbers.add(7);
   listOfNumbers.add(20);
   listOfNumbers.add(35);
   listOfNumbers.add(3);
   listOfNumbers.add(25);


    ArrayList<Integer> numberList = new ArrayList<>();

    numberList.add(1);
    numberList.add(5);
    numberList.add(7);
    numberList.add(4);
    numberList.add(3);
    numberList.add(3);
    Collections.sort(numberList);

    System.out.println("MEAN, MEDIAN, MODE, STANDARD DEV");
    System.out.println("The first list is: " + listOfNumbers + "\n" + "The second list is: " + numberList + "\n" + "");


    System.out.println("The mean of " + listOfNumbers + " is: " + testMean.computeMean(listOfNumbers));

    System.out.println("The median of " + numberList +  " is: " + testMean.computeMedian(numberList));

    System.out.println("The Standard deviation of " + listOfNumbers +  " is: " + testMean.computeStandardDeviation(listOfNumbers));

    System.out.println("The variation of " + numberList + " is " + testMean.computeVariation(listOfNumbers));
    System.out.println("The mode of " + numberList + " is: " + testMean.computeMode(numberList) + "\n" + "");
   
    System.out.println("COMBINATION, PERM, FACTORIAL");
    System.out.println("The factorial of 5 is: " + testComb.computeFactorial(5));
    System.out.println("The combination of n=7, r=5 is: " + testComb.computeCombination(7, 5));
    System.out.println("The permutation of n=6, r=4 is: " + testComb.computePermutation(6, 4) + "\n");


   
    System.out.println("INTERSECTION, UNION and COMPLEMENT");
    System.out.println("The first list is " + numberList);
    System.out.println("The second list is " + listOfNumbers + "\n" + "");
   

    System.out.println("The intersection is: "  + testOp.computeIntersection(listOfNumbers, numberList));
    System.out.println("The union is: " + testOp.computeUnion(listOfNumbers, numberList));
    System.out.println("The complement of the first list is: " + testOp.computeComplement(numberList, listOfNumbers) + "\n");

    
    System.out.println("Binominal distribution and geometric");
    System.out.println("The binominal distribution of a league of legends team is: " + testDis.computeBinomialDistribution(.15, 10, 4));
    System.out.println("The geometric probability of auditing (2.73): " + testDis.computeGeometricDistribution(.90, 3, 1) + "\n");
    
    System.out.println("CONDITIONAL, BAYES, DEPENDENCE, INDEPEDENCE");
    System.out.println("The conditional probability of P(A) = .5 and P(B) = .2: " + testCon.computeConditionalProbability(.50, .20));
    System.out.println("The answer to the bayes theorem problem  is: (2.124) " + testCon.computeBayesTheorem(40., .60));
    System.out.println("Is this PA= .30 and PB=.10 independent? : " + testCon.isIndependent(.30, .10, 0.03));

    
}
}


