import java.util.ArrayList;



public class SetOperations {

    // a class that contains multiple set operations using arraylists....


/**
 * Computes the intersection of two lists by finding elements that are common to both.
 * 
 * <p>This method goes through the elements of the first list, checks if each element 
 * exists in the second list, and adds the element to the intersection list if it is present in both.
 * 
 * @param listOfNumbers the first list of integers 
 * @param numberList the second list of integers
 * @return an ArrayList containing the elements common to both lists
 */
public ArrayList<Integer> computeIntersection(ArrayList<Integer> listOfNumbers, ArrayList<Integer> numberList){

ArrayList<Integer> intersectionList = new ArrayList<>();

int size = Math.min(listOfNumbers.size(), numberList.size());

for (int i = 0; i < size; i++){
    int currentElement = listOfNumbers.get(i);


    if (numberList.contains(currentElement)){
        intersectionList.add(currentElement);
    }

}
return intersectionList;
   
}


/**
 * Computes the union of two lists by putting together all unique elements from both lists.
 * 
 * <p>This method goes through through each list and adds elements to the union list only if 
 * they are not already there. The end union list contains each element at most once.
 * @param listOfNumbers the first list of integers
 * @param numberList the second list of integers
 * @return an ArrayList containing all unique elements from both lists
 */
public ArrayList<Integer> computeUnion(ArrayList<Integer> listOfNumbers, ArrayList<Integer> numberList){

    ArrayList<Integer> unionList = new ArrayList<>();


    for (int i = 0; i < listOfNumbers.size(); i++) {
        int currentElement = listOfNumbers.get(i);
        if (!unionList.contains(currentElement)) {
            unionList.add(currentElement);
        }
    }

        for (int i = 0; i < numberList.size(); i++) {
            int currentElement = numberList.get(i);
            if (!unionList.contains(currentElement)) {
                unionList.add(currentElement);
            }

            
        }
        return unionList;

    }


/**
 * Computes the complement of two lists by finding elements in the 
 * arraylist `listOfNumbers` that are not found in the the other arraylist `numberList`.
 *
 * @param numberList      the list of integers to compare 
 * @param listOfNumbers   the second list of integers 
 * @return                a new ArrayList containing elements from 
 *                        `listOfNumbers` that are not in `numberList`
 */
  public ArrayList<Integer> computeComplement(ArrayList<Integer> numberList, ArrayList<Integer> listOfNumbers){
       
        
 ArrayList<Integer> complementList = new ArrayList<>();

  for (int currentElement : listOfNumbers){
           
    if (!numberList.contains(currentElement)) {
         complementList.add(currentElement);
      }

      }
      return complementList;

    }

}
    
    

