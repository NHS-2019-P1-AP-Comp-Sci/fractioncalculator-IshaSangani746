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
    	userInput.toLowerCase();
    	while (userInput.equals("quit") == false){ 
    		String Result = produceAnswer(userInput);
    		System.out.println(Result);
    		System.out.println("What is the calculation you want me to perform?");
    		userInput = scanner.nextLine();
    	}
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
    	int operation = Input.indexOf(" ");
    	char operationChar = Input.charAt(operation + 1);
    	String Number1 = ""; 
    	String Number2 = ""; 
    	if (operation >= 2) {
    		Number1 += Input.substring(0, operation);
    	}else if (operation <2) {
    		Number1 += Input.charAt(0); 
    	}  
    	if ((Input.length()-1) - operation >= 3) {
    		Number2 += Input.substring(operation + 3, Input.length());
    	}else if (Input.length()-1 - operation < 3) {
    		Number2 += Input.charAt(Input.length()-1);
    	}
    	//Declare numerator, denominator, whole, assign default values to them
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
	        	System.out.print("whole:" + whole1 + " ");
	        	//Declare a String for the numerator and then parse and print it
		        String Numerator1 = Number1.substring(underscore1 + 1, vinculum1); 
		        numerator1 = Integer.parseInt(Numerator1);
		        System.out.print("numerator:" + numerator1 + " ");
        	}
        	//Declare a string for denominator from the vinculum to the end.
        	String Denominator1 = Number1.substring(vinculum1 + 1); 
        	//then parse and print the string.
        	denominator1 = Integer.parseInt(Denominator1);
        	System.out.println("denominator:" + denominator1);  
	        	
        	if (underscore1 == -1) {
        		//Declare a String for the numerator and then parse and print it
		        String Numerator1 = Number1.substring(0, vinculum1); 
		        numerator1 = Integer.parseInt(Numerator1);
		        System.out.print("numerator:" + numerator1 + " "); 
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
	        	//System.out.print("whole:" + whole + " ");
	        	//Declare a String for the numerator and then parse and print it
		        String Numerator = Number2.substring(underscore + 1, vinculum); 
		        numerator = Integer.parseInt(Numerator);
		        //System.out.print("numerator:" + numerator + " ");
        	}
        	//Declare a string for denominator from the vinculum to the end.
        	String Denominator = Number2.substring(vinculum + 1); 
        	//then parse and print the string.
        	denominator = Integer.parseInt(Denominator);
        	//System.out.println("denominator:" + denominator);  
	        	
        	if (underscore == -1) {
        		//Declare a String for the numerator and then parse and print it
		        String Numerator = Number2.substring(0, vinculum); 
		        numerator = Integer.parseInt(Numerator);
		        System.out.print("numerator:" + numerator + " "); 
        	}
        //If there is no vinculum, then it's just whole--so parse Number2 as is
        }else {
        	whole = Integer.parseInt(Number2); 
        }
       return "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator; 
    }

}

    // TODO: Fill in the space below with any helper methods that you think you will need


