
import java.util.Scanner;

/**
 * Poly class has 8 methods 
 * evaluate {which evaluate the polynomial taking parameters of value of polynomial variable, returns integer value.}
 * degree {this method finds the maximum power of polynomial variable, return degree of polynomial.}
 * returnInputPoly { it returns polynomial after taking input from user }
 * addPolynomial {it add 2 polynomial taking parameter as a object of polynomial class and returns added polynomial }
 * multiplyPoly {it multiply 2 polynomial taking parameter as a object of polynomial class and returns multiplied polynomial}
 * printPoly {prints polynomial after taking array as parameter }
 * main {where the program starts on console}
 * @author yash.porwal_metacube
 *
 */
public final class Poly {
    
     final static int [] polynomial = new int[15];
	
    
    /**
     * Poly constructor which takes user input for coefficient 
     */
	Poly(){}
	
	/**
	 * this method evaluate the polynomial
	 * @param valueOfX input from user, value of polynomial expression x.
	 * @return it returns integer value which is evaluated value of polynomial.
	 */
 	public static int evaluate(float valueOfX) {
 		
 		int total = 0;
 		for(int i=0; i<polynomial.length; i++) {
 				total += polynomial[i] * Math.pow(valueOfX, i);
 			}
 		return total;
			 
 		}
 	
 	/**
 	 * this finds the highest degree of polynomial
 	 * @return highest degree in integer
 	 */
 	public static int degree() {
 		for(int i=polynomial.length - 1 ; i>=0; i--){
 			if(polynomial[i] !=0){
 				return i;
 			}
 		}
 		return 0;
 	}	
 	
 	/**
 	 * this method places polynomial to unchanged polynomial 
 	 * array of data member of a class
 	 * it takes input input from the user regarding input and 
 	 * places in the polynomial
 	 */
 	public void inputPoly(){
 		Scanner sc = new Scanner(System.in);
 		int maxPower;
 		System.out.print("Enter Maximum Power of Polynomial: ");
 		maxPower = sc.nextInt();
 		for(int i=0; i<=maxPower; i++) {
 			System.out.printf("Enter the Coefficient of %dth Power of Polynomial: ", i);
 			polynomial[i] = sc.nextInt();
 		}
 		for(int i = maxPower+1; i<polynomial.length; i++) {
 			polynomial[i] = 0;
 		}
 	}
 	
 	
 	/**
 	 * this return the polynomial of user input value of coefficients of polynomial 
 	 * @return array of coefficients of polynomial
 	 */
 		public int[] returnInputPoly(){
 		Scanner sc = new Scanner(System.in);
 		int maxPower;
 		System.out.print("Enter Maximum Power of Polynomial: ");
 		maxPower = sc.nextInt();
 		int [] polynomial = new int[maxPower+1];
 		for(int i=0; i<=maxPower; i++) {
 			System.out.printf("Enter the Coefficient of %dth Power of Polynomial: ", i);
 			polynomial[i] = sc.nextInt();
 		}
 		for(int i = maxPower+1; i<polynomial.length; i++) {
 			polynomial[i] = 0;
 		}
 		return polynomial;
 	}
 
 	/**
 	 * it adds two user input polynomial
 	 * @param p1 object of Poly class
 	 * @param p2 object of Poly class
 	 * @return it returns added polynomial in integer array
 	 */
 	public static int [] addPolynomial(Poly p1, Poly p2) {
 		int [] poly1 = p1.returnInputPoly();
 		int [] poly2 = p2. returnInputPoly();
 		int maxIndex = Math.max(poly1.length, poly2.length);
 		int [] addPoly  = new int[maxIndex];
 		for(int i=0; i<maxIndex; i++){
 			if(i < poly1.length && i< poly2.length) {
 				addPoly[i] = poly1[i] + poly2[i];
 			}
 			else if(i>=poly1.length && i<poly2.length) {
 				addPoly[i] = poly2[i];  
 			}
 			else if(i<poly1.length && i>=poly2.length) {
 				addPoly[i] = poly1[i];
			}
 		}
 		return addPoly;
 	}
 
 	/**
 	 * this multiply two user input multiply 
 	 * @param p1 it is the object of class Poly
 	 * @param p2 it is the object of class Poly
 	 * @return it return the multiplied polynomial in the integer array form 
 	 */
 	public static int[] multiplyPoly(Poly p1, Poly p2){
 		int [] poly1 = p1.returnInputPoly();
 		int [] poly2 = p2.returnInputPoly();
 		int poly1Length = poly1.length;
 		int poly2Length = poly2.length;
 		int [] mulPoly  = new int[(poly1Length-1)  + (poly2Length-1) + 1];
 		for(int i=0; i<poly1Length; i++){
 			for(int j=0; j<poly2Length; j++){
 				mulPoly[i+j] += (poly1[i] * poly2[j]) ;
 			}
 		}
 		return mulPoly;
 	}
 	
 	/**
 	 * this method prints the polynomial 
 	 * @param poly it prints that  polynomial 
 	 */
 	public static void printPoly(int [] poly){
 		for(int i=poly.length-1; i>=0; i--) {
 			if(poly[i] == 0){
 				continue;
 			}
			System.out.print(poly[i] + "x^" + i +" ");
 		}
 	}
 	
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Poly polyObj = new Poly();
		System.out.println("1. Evaluate \n2. Degree of Polynomial \n3. Add Polynomial \n4. Multiply Polynial \nEnter your Choice: ");
 		int choice = sc.nextInt();
 		
		switch(choice){
		
			case 1: polyObj.inputPoly();
					System.out.print("Enter the value of Polynomial: ");
					float valueOfPolynomial = sc.nextFloat();
					int evaluateValue = evaluate(valueOfPolynomial);
					System.out.println("Evaluated Value is " + evaluateValue);
					break;
					
			case 2: polyObj.inputPoly();
					int degree = degree();
					System.out.println("Degree of Polynomial is " + degree);
					break;
					
			case 3: int [] addPoly = addPolynomial(new Poly(), new Poly());
					printPoly(addPoly);
					break;
					
			case 4: int [] mulPoly = multiplyPoly(new Poly(), new Poly());
					printPoly(mulPoly);
					break;
			default: System.out.println("Enter the Correct Choice");
		}
	}	
}
