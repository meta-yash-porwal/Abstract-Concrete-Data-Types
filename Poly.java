/*
 * class Poly has 8 methods - 
 * evaluate {which evaluate the polynomial taking parameters of value of polynomial variable, returns integer value.}
 * degree {this method finds the maximum power of polynomial variable, return degree of polynomial.}
 * returnInputPoly { it returns polynomial after taking input from user }
 * addPolynomial {it add 2 polynomial taking parameter as a object of polynomial class and returns added polynomial }
 * multiplyPoly {it multiply 2 polynomial taking parameter as a object of polynomial class and returns multiplied polynomial}
 * printPoly {prints polynomial after taking array as parameter }
 * main {where the program starts on console}
 */


import java.util.Scanner;


public final class Poly {
	static Scanner sc = new Scanner(System.in);
	static int maxPower;
	static int [] polynomial;
	
	Poly(){}
	
 	public static int evaluate(int valueOfX) {
 		int total = 0;
 		for(int i=0; i<=maxPower; i++) {
 				total += polynomial[i] * Math.pow(valueOfX, i);
 			}
 		return total;
			 
 		}
 	
 	public static int degree() {
 		for(int i=polynomial.length - 1 ; i>=0; i--){
 			if(polynomial[i] !=0){
 				return i;
 			}
 		}
 		return 0;
 	}	
 	public int[] returnInputPoly(){
 		System.out.print("Enter Maximum Power of Polynomial: ");
 		maxPower = sc.nextInt();
 		polynomial = new int[maxPower+1];
 		for(int i=0; i<=maxPower; i++) {
 			System.out.printf("Enter the Coefficient of %dth Power of Polynomial: ", i);
 			polynomial[i] = sc.nextInt();
 		}
 		return polynomial;
 	}
 
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
 	
 	public static void printPoly(int [] poly){
 		for(int i=poly.length-1; i>=0; i--) {
			System.out.print(poly[i] + "x^" + i +" ");
 		}
 	}
 	
	public static void main(String[] args) {
		Poly polyObj = new Poly();
		System.out.println("1. Evaluate \n2. Degree of Polynomial \n3. Add Polynomial \n4. Multiply Polynial \nEnter your Choice: ");
 		int choice = sc.nextInt();
		switch(choice){
		
			case 1: polyObj.returnInputPoly();
					System.out.print("Enter the value of Polynomial: ");
					int valueOfPolynomial = sc.nextInt();
					int evaluateValue = evaluate(valueOfPolynomial);
					System.out.println("Evaluated Value is " + evaluateValue);
					break;
					
			case 2: polyObj.returnInputPoly();
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
