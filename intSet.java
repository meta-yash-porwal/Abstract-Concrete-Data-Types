import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

/**
 * class intSet has 7 methods
 * intSet() is default constructor 
 * aInput { this method takes a input }
 * isMember {checks a number is a part of the array or not takes parameter of that number}
 * isSubset {checks an subset(array) is a subset of an array}
 * union {takes 2 set(array ) and return there union}
 * getComplement {complement of an array}
 * returnSetValue {it return an array which takes user input to make an array }
 * main {where the program starts at console}
 * @author yash.porwal_metacube
 *
 */
public final class intSet {

	final private static Integer arr[] = new Integer[ThreadLocalRandom.current().nextInt(201, 901)];
	
	intSet(){}
	
	/**
	 * it takes an input from user 
	 * @return an input from user
	 */
	public static int aInput(){
		Scanner sc = new Scanner(System.in);
		int choice;
		choice = sc.nextInt();	
		return choice;
	}

	/**
	 * checks that an element(integer number) is a member of array or not
	 * @param x it's an element which has been checked
	 * @return boolean i.e., true (if found) or false (not found)
	 */
	public static boolean isMember(int x) {
		for(int i=0; i<arr.length; i++){
			if(arr[i] == x){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * checks the set is a subset of arr[] (integer array) or not. 
	 * @param s is the object of intSet 
	 * @return it returns boolean - true (subset) or false (not subset)
	 */
	public static boolean isSubSet(intSet s){
		Set<Integer> set = s.returnSetValues("Subset");
		/*
		 * TreeSet converts the set into ascending no (small to big)
		 */
		Set<Integer> arrSet = new TreeSet<Integer>(Arrays.asList(arr));
		return(arrSet.containsAll(set));
	}
	
	/**
	 * this takes the union of two sets into unionSet
	 * @param s1 is the object of intSet used to make set1 (set) values
	 * @param s2 is the object of intSet used to make set2 (set) values
	 * @return it returns the set (unionSet) which is union of two sets.
	 */
	public static Set<Integer> union(intSet s1, intSet s2) {
		Set<Integer>set1 =  s1.returnSetValues("Set1");
		Set<Integer>set2 = s2.returnSetValues("Set2");
		Set<Integer> unionSet = new HashSet<Integer>(set1);
		unionSet.addAll(set2);
		return unionSet;
		
	}
	
	/**
	 * this method gives the complement of numbers in arr[] (integer array ) 
	 * @return the complemented set of integer values
	 */
	public static Set<Integer> getComplement(){
		Set<Integer> universalSet = new HashSet<Integer>();
		for(int i=1; i<=1000; i++){
			universalSet.add(i);
		}
		/*
		 * TreeSet converts the set into ascending no (small to big)
		*/
		Set<Integer> arrSet = new TreeSet<Integer>(Arrays.asList(arr));
		Set<Integer> complementSet = new HashSet<Integer>(universalSet);
	    complementSet.removeAll(arrSet);
	    return complementSet;
	}
	
	/**
	 * this method return set values by taking user input 
	 * @param str input of which type of set Eg.,(Subset, Set1, Set2, etc)
	 * @return it return the set values input by user
	 */
	public Set<Integer> returnSetValues(String str) {
		Set<Integer> set = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.print(String.format("Enter No. of elements in %s: ", str));
		  int choice = aInput();
		  for(int i=1; i<=choice; i++){
			  System.out.printf("Enter %d element: ", i);
			  int no = sc.nextInt();
			  set.add(no);
		  }
		  return set;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = 1;
	    int max = 1000;  
	    for(int i =0; i<arr.length; i++ ) {
	    int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
	    arr[i] = randomNum;
	    }
	    System.out.print("Random Array No.: ");
		Set<Integer> arrSet = new TreeSet<Integer>(Arrays.asList(arr));
		System.out.println(arrSet);
	    System.out.println("\n1. isMember \n2. Size of Array \n3. isSubSet \n4. getComplement \n5. union");
	    System.out.print("Enter Your Choice: ");
	    int choice = aInput();
	    switch(choice) {
	    	case 1 :  System.out.print("Enter a no. to check : ");
	    			  choice = aInput();
	    		      System.out.println(isMember(choice));
	    		      break;
	    		      
	    	case 2:   System.out.println(arr.length);
	    			  break;
	    			  
	    	case 3:   System.out.println(isSubSet(new intSet()));
	    			  break;
	    			  
	    	case 4:   Set<Integer> complementSet = getComplement();
	    			  System.out.println(complementSet);
	    			  break;
	    			  
	    	case 5:   Set<Integer> unionSet = new HashSet<Integer>();
	    			  unionSet = union(new intSet(), new intSet());
	    			  System.out.println(unionSet);
	    				break;
	    	case 0: System.exit(0);
	    	
	    }
	}
	
}


