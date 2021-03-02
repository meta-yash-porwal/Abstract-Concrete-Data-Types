/*
 * class intSet has 7 methods
 * intSet() is default constructor 
 * aInput { this method takes a input }
 * isMember {checks a number is a part of the array or not takes parameter of that number}
 * isSubset {checks an subset(array) is a subset of an array}
 * union {takes 2 set(array ) and return there union}
 * getComplement {complement of an array}
 * returnSetValue {it return an array which takes user input to make an array }
 * main {where the program starts at console}
 */



import java.util.concurrent.ThreadLocalRandom;
import java.util.*;


public final class intSet {
	static int choice;
	static Integer arr[] = new Integer[ThreadLocalRandom.current().nextInt(201, 901)];
	
	intSet(){}
	
	public static void aInput(){
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();	 
	}

	public static boolean isMember(int x) {
		for(int i=0; i<arr.length; i++){
			if(arr[i] == x){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isSubSet(intSet s){
		Set<Integer> set = s.returnSetValues("Subset");
		Set<Integer> arrSet = new TreeSet<Integer>(Arrays.asList(arr));
		return(arrSet.containsAll(set));
			
	}
	
	public static Set<Integer> union(intSet s1, intSet s2) {
		Set<Integer>set1 =  s1.returnSetValues("Set1");
		Set<Integer>set2 = s2.returnSetValues("Set2");
		Set<Integer> unionSet = new HashSet<Integer>(set1);
		unionSet.addAll(set2);
		return unionSet;
		
	}
	
	public static Set<Integer> getComplement(){
		Set<Integer> universalSet = new HashSet<Integer>();
		for(int i=1; i<=1000; i++){
			universalSet.add(i);
		}
		Set<Integer> arrSet = new TreeSet<Integer>(Arrays.asList(arr));
		Set<Integer> complementSet = new HashSet<Integer>(universalSet);
	    complementSet.removeAll(arrSet);
	    return complementSet;
	}
	
	public Set<Integer> returnSetValues(String str) {
		Set<Integer> set = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.print(String.format("Enter No. of elements in %s: ", str));
		  aInput();
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
	    aInput();
	    switch(choice) {
	    	case 1 :  System.out.print("Enter a no. to check : ");
	    			  aInput();
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


