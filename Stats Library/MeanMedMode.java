import java.util.ArrayList;
import java.util.Collections;



public class MeanMedMode {


/**
 * Computes the mean (average) of a list of integers.
 *
 * @param listOfNumbers an ArrayList of Integer values for which the mean is to be calculated
 * @return the mean of the numbers in the list as a double
 */

public double computeMean(ArrayList<Integer> listOfNumbers){
    int sum = 0;
    for( int singleNumber : listOfNumbers){
        sum = sum + singleNumber;
    }
    return sum / (double) listOfNumbers.size();
}

/**
 * Computes the median of a list of integers.
 *
 * <p>The median is the value in the middle of a data set, depending on if it's odd or even.
 * This method sorts the input list and then calculates the median based on whether the number
 * of elements is odd or even.</p>
 *
 * @param numberList an ArrayList of Integer values for which the median is to be calculated
 * @return the median of the numbers in the list as a double value
 */

public double computeMedian(ArrayList<Integer> numberList){

//sorting elements smallest to largest (just in case)
    Collections.sort(numberList);

    int size = numberList.size();
    double median;

/* two cases:
 * case 1: odd number of elements
 * case 2: even number of elements
*/
if (size % 2 == 1) {
    median = numberList.get(size / 2);
} else {
    median = (numberList.get(size / 2) + numberList.get((size / 2) - 1)) / 2.0;
}

return median;
}




/**
 * Computes the mode of a list of integers.
 *
 * <p>The mode is the value that appears most in a data set. 
 * This method goes through the list to count occurrences of each number 
 * and determines which number has the highest count.</p>
 *
 * @param numberList an ArrayList of Integers for which the mode is to be calculated
 * @return the mode of the numbers in the list
 */

public int computeMode(ArrayList<Integer> numberList){
    int mainCount = 0;
    int mode = numberList.get(0);
    int size = numberList.size();

    for (int i= 0; i < size; i++){
        int count = 0;
        int num = numberList.get(i);

        for(int j = 0; j < size; j++){
            if (numberList.get(j).equals(numberList.get(i))) {
                count++;

            }
        }

        if (count > mainCount){
            mainCount = count;
            mode = num;

        }

        
    }
    return mode;
}




/**
 * Computes the variance of a list of integers.
 *
 * <p>Variance is a measure of how much the numbers in a dataset deviate 
 * from the mean. This method calculates the mean of the numbers, then 
 * computes the average of the squared differences between each number 
 * and the mean.</p>
 *
 * @param listOfNumbers an ArrayList of Integer values to work with to find the variance
 * @return the variance of the numbers inputted into the list
 */

public double computeVariation(ArrayList<Integer> listOfNumbers){
    double mean = computeMean(listOfNumbers);

    int sumDifference = 0;
    for (int number : listOfNumbers){
        sumDifference += Math.pow(number - mean, 2);
    }

    return sumDifference / listOfNumbers.size();
}

/**
 * Computes the standard deviation of a list of integers.
 *
 * <p>The standard deviation is a measure of the amount of variation 
 *  in a set of values. This method calculates the variance of 
 * the provided numbers and returns the square root of that variance.</p>
 *
 * @param listOfNumbers a list of integers to work with to find the SDV
 * @return the standard deviation of the numbers in the list
 */

public double computeStandardDeviation(ArrayList<Integer> listOfNumbers){
    
    
    double variation = computeVariation(listOfNumbers);

    

    return Math.sqrt(variation / (double) listOfNumbers.size());
}
}
