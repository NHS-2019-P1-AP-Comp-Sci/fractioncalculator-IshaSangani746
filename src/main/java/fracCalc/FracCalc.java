/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*; 
public class FracCalc {

    public static void main(String[] args){
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner scanner = new Scanner(System.in); 
    	System.out.println("What is the calculation you want me to perform?");
    	String userInput = scanner.nextLine(); 
    	//While loop keeps asking the user for an equation until the user says "quit"
    	userInput.toLowerCase();
    	while (userInput.equals("quit") == false){ 
    		String Result = produceAnswer(userInput);
    		System.out.println(Result);
    		System.out.println("What is the calculation you want me to perform?");
    		userInput = scanner.nextLine();
    	}
    	//When user hits quit, tell them they have ended the calculator
    	System.out.println("OK, you have ended the calculator."); 
    scanner.close(); 
    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"

    public static String produceAnswer(String Input) {
        // TODO: Implement this function to produce the solution to the input
    	//Locate the index and character of the operation character
    	int operation = Input.indexOf(" ");
    	char operationChar = Input.charAt(operation + 1);
    	//Create 2 empty strings for the numbers, and then add to them later. 
    	//This allows the strings to be used throughout the method. 
    	String Number1 = ""; 
    	String Number2 = ""; 
    	//Locate Number1
    	if (operation >= 2) {
    		Number1 += Input.substring(0, operation);
    	}else if (operation <2) {
    		Number1 += Input.charAt(0); 
    	}  
    	//Locate Number2
    	if ((Input.length()-1) - operation >= 3) {
    		Number2 += Input.substring(operation + 3, Input.length());
    	}else if (Input.length()-1 - operation < 3) {
    		Number2 += Input.charAt(Input.length()-1);
    	}
    	//Print numbers for checking
    	System.out.println("Number1: " + Number1 + operationChar + " Number2: " + Number2+ " ");     	
    	//Declare numerator, denominator, whole. assign default values to them
    	int numerator1 = 0;
    	int denominator1 = 1; 
    	int whole1 = 0;
    	//parse Number1
    	int underscore1 = Number1.indexOf("_"); 
    	//Find the vinculum, or the fraction bar, by searching using IndexOf on Number2
        int vinculum1 = Number1.indexOf("/");
        
        if (vinculum1 != -1) { 
        	if (underscore1 != -1) {
	        	//Declare a String that is Number1 up until the underscore - in other words, the whole #
	        	String Whole1 = Number1.substring(0, underscore1); 
	        	whole1 = Integer.parseInt(Whole1); 
	        	//Declare a String for the numerator and then parse and print it
		        String Numerator1 = Number1.substring(underscore1 + 1, vinculum1); 
		        numerator1 = Integer.parseInt(Numerator1);
		        if (whole1 < 0) {
		        	numerator1 *= -1; 
		        }
        	}
        	//Declare a string for denominator from the vinculum to the end.
        	String Denominator1 = Number1.substring(vinculum1 + 1); 
        	//then parse and print the string.
        	denominator1 = Integer.parseInt(Denominator1);
        	if (underscore1 == -1) {
        		//Declare a String for the numerator and then parse and print it
		        String Numerator1 = Number1.substring(0, vinculum1); 
		        numerator1 = Integer.parseInt(Numerator1);
        	}
        //If there is no vinculum, then it's just whole--so parse Number1 as is
        }else {
        	whole1 = Integer.parseInt(Number1); 
        }
        //Declare default variables for Number2 - will print as is if #2 is only a whole
        int numerator = 0;
    	int denominator = 1; 
    	int whole = 0;
    	//parse, return whole, numerator, denominator for Number2
    	//Search for the underscore to find out if it's a mixed number
        int underscore = Number2.indexOf("_"); 
    	//Find the vinculum, or the fraction bar, by searching using IndexOf on Number2
        int vinculum = Number2.indexOf("/");
        
        if (vinculum != -1) { 
        	if (underscore != -1) {
	        	//Declare a String that is Number2 up until the underscore - in other words, the whole #
	        	String Whole = Number2.substring(0, underscore); 
	        	whole = Integer.parseInt(Whole); 
	        	//Declare a String for the numerator and then parse and print it
		        String Numerator = Number2.substring(underscore + 1, vinculum); 
		        numerator = Integer.parseInt(Numerator);
		        if (whole < 0) {
		        	numerator *= -1; 
		        }
		       
        	}
        	//Declare a string for denominator from the vinculum to the end.
        	String Denominator = Number2.substring(vinculum + 1); 
        	//then parse and print the string.
        	denominator = Integer.parseInt(Denominator);  
	        	
        	if (underscore == -1) {
        		//Declare a String for the numerator and then parse and print it
		        String Numerator = Number2.substring(0, vinculum); 
		        numerator = Integer.parseInt(Numerator);
		        }
        //If there is no vinculum, then it's just whole--so parse Number2 as is
        }else {
        	whole = Integer.parseInt(Number2); 
        }
       String Answer = calculate(whole1, numerator1, denominator1, whole, numerator, denominator, operationChar); 
       return Answer;  
    }
    public static String calculate(int w1, int n1, int d1, int w2, int n2, int d2, char op) {
    	//Set default values for wholeResult, numResult, and denResult. 
    	//These can be changed depending on the numbers.
    	int wholeResult = 0; 
    	int numResult = 0; 
    	int denResult = 1; 
    	if (op == '+') {
    		//Add the two numbers!
    		wholeResult = w1 + w2; 
    		denResult = d1 * d2; 
    		numResult = (n1*d2) + (n2*d1); 
    	}if (op == '-') {
    		//First, assign numerators for mixed numbers as converted to improper fractions
    		int improperNum1 = (w1*d1) + n1; 
    		int improperNum2 = (w2*d2) + n2; 
    		//Subtract the two numbers!
    		denResult = d1 * d2; 
    		numResult = (improperNum1*d2) - (improperNum2*d1); 
    	}if (op == '*') {
    		//Multiplication by 0
    		if ((w1==0&&n1==0)||(w2==0&&n2==0)) {
        		return "0";    
        	}
    		//Declare numerators for mixed numbers as converted to improper fractions
    		int improperNum1 = (w1*d1) + n1; 
    		int improperNum2 = (w2*d2) + n2; 
    		//Multiply the numerators and denominators
    		numResult = (improperNum1 * improperNum2); 
    		denResult = d1*d2; 
    	}if (op == '/') {
    		//Declare numerators for mixed numbers as converted to improper fractions
    		int improperNum1 = (w1*d1) + n1; 
    		int improperNum2 = (w2*d2) + n2;
    		//Switch the numerator and denominator of the second numer
    		int usefulNum2 = d2; 
    		int usefulDen2 = improperNum2; 
    		//Multiply the numerators and denominators using the reciprocal
    		numResult = (improperNum1 * usefulNum2); 
    		denResult = (d1 * usefulDen2);
    	}
    	String K = improperFractions(wholeResult, numResult, denResult); 
    	return K; 
    }
    //The improperFractions() method turns improper fraction (after the evaluation) into mixed number. 
    public static String improperFractions(int whole, int num, int den) {  
    	if (Math.abs(num) > Math.abs(den)) {
			//Scenario where the result has an improper fraction. 
    		//Add new whole numbers to TotalWhole. 
    		int totalWhole = ((num - (num % den))/den) + whole; 
			num = Math.abs(num % den); 
			den = Math.abs(den); 
			//capture the result of reduceFractions in the String Reduced.
			String Reduced = reduceFractions(totalWhole, num, den);
			return Reduced; 
		}else {
			//Scenario where there are no improper fractions, then the whole number stays as is
			int totalWhole = whole; 
			String Reduced = reduceFractions(totalWhole, num, den);
			if (whole == 0 ) {
				return Reduced; 
			}
			if (Reduced.equals("-1")||Reduced.equals("1)")) {
				int reduced = totalWhole + Integer.parseInt(Reduced); 
				return "" + reduced; 
			}
			else return Reduced;
		} 
    }
    //The reduceFractions() method reduces fractions. 
    public static String reduceFractions(int w, int n, int d) {
    	//Return 1 if the numer
    	if (n == d) {
    		return "1"; 
    	}
    	if (n == -1*d) {
    		return "-1"; 
    	}
    	int cap = Math.abs(n); 
    	for (int i = cap; i > 1; i--) {
    		if ((n % i == 0)&&(d % i == 0)) {
    			n /= i; 
    			d /= i;	 
    		}
    	if (w/n > 0) {
    		n = Math.abs(n); 
    	}
    	}return w + "_" + n + "/" + d;
    }
}

    // TODO: Fill in the space below with any helper methods that you think you will need


