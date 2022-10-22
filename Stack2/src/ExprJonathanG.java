// Class:		CS 5040
// Term:		Fall 2022
// Name:		Jonathan J. Gomez
// Program Number:	Assignment 3 - Part 2&3&4
// IDE: 		Eclipse, JDK 15.0.1

import java.util.*;
public class ExprJonathanG {

	public static void main(String[] args) {
		//String infix = "3" + "+" + "4";
		Scanner x = new Scanner(System.in);
		boolean cont = true;
		
		while (cont == true) {
		System.out.print("Enter an infix: \t");
		String str = x.next();


		System.out.println("Postfix Evaluation: \t" +infixToPostfix(str));
		System.out.println("Result value: \t\t" +postfixEval(infixToPostfix(str)));
		
		
		System.out.println("Do you want to try another expression? \t");
		char ans = x.next().charAt(0);

		if (ans == 'y' || ans == 'Y') {
			System.out.println();
			cont = true;
		}if (ans == 'n' || ans == 'N') {
			System.out.println("TERMINATED");
			cont = false;
		}
		}

	}





	public static String infixToPostfix(String infix) {
		MyStackJonathanG<String> myStack = new MyStackJonathanG<>();


		String str = "";
		int character = 0;


		while(character <= infix.length()-1) {

			String token = getNextToken(infix, character); //Invoke method to select first character from left to right from the string;

			int temp = (int)token.charAt(0);// change token value to ANSII code
											// since we know the ANSI value of 0-9
			if(temp >=48 && temp<=57 ) {    //Make if condition from 0 to 9 in ANSII
				//if(token == "1"|| token == "2"||token == "3"|| token == "4"||token == "5"||token == "6"|| token == "7"||token == "8"|| token == "9"||token == "0") {

				str = str +  token ;

			}

			else {  	//Else if value is other than a operand 
				switch(token) { // switch between them and see which one is the token

				case "+":
					if(!myStack.isEmpty()) {
						String Op = myStack.peek();
						char a = Op.charAt(0);
						int b = (int)a;  
						if(b == 42|| b==47 || b==94 || b == 45 || b == 43) {// use ANSII to verify if the value is "*", "/", "^"

							while(!myStack.isEmpty()) {
								str = str + myStack.pop();
							}

						}
					}

					myStack.push(token);

					break;


				case "-":
					if(!myStack.isEmpty()) { // Verify if stack has an operator
						String Op = myStack.peek(); // create a string to change to char
						char a = Op.charAt(0);
						int b = (int)a;  // b will hold decimal value of char in ANSII
						if(b == 42|| b==47 || b==94 || b == 43 || b == 45) {// use ANSII to verify if the value is "*", "/", "^"

							while(!myStack.isEmpty()) {
								str = str + myStack.pop();
							}

						}
					}

					myStack.push(token);
					break;

				case "*":

					if(!myStack.isEmpty()) { // Verify if stack has an operator
						String Op = myStack.peek(); // create a string to change to char
						char a = Op.charAt(0);
						int b = (int)a;  // b will hold decimal value of char in ANSII

						if(b == 47 || b == 94 || b == 42) {

							while(!myStack.isEmpty()) {
								str = str + myStack.pop();
							}
						}
					}
					myStack.push(token);
					break;


				case "/":

					if(!myStack.isEmpty()) { // Verify if stack has an operator
						String Op = myStack.peek(); // create a string to change to char
						char a = Op.charAt(0);
						int b = (int)a;  // b will hold decimal value of char in ANSII

						if(b == 42 || b == 94 || b == 47) {

							while(!myStack.isEmpty()) {
								str = str + myStack.pop();
							}
						}
					}
					myStack.push(token);
					break;


				case "^":

					if(!myStack.isEmpty()) { // Verify if stack has an operator
						String Op = myStack.peek(); // create a string to change to char
						char a = Op.charAt(0);
						int b = (int)a;  // b will hold decimal value of char in ANSII

						if(b == 94 ) {

							while(!myStack.isEmpty()) {
								str = str + myStack.pop();
							}
						}
					}
					myStack.push(token);
					break;

				case "(":	//If token is "(" push it into stack

					myStack.push(token);
					break;

				case ")": 	// When token is ")" push all operators except "("

					while(!myStack.peek().equals("(")) {
						str = str + myStack.pop();
						
					}
					myStack.pop();
					
					break;

					default:
						System.out.println("\""+token +"\""+ " Is neither an operand or operator\nProgram Terminated");
						System.exit(0);
						break;



				}
			}
			character ++;

			
		}
		// If Stack is not empty the pop all operators
		while(!myStack.isEmpty()) {

			str = str+myStack.pop();

		}
		
		return str;
	} 


	public static double postfixEval(String postfixExpr) {

		MyStackJonathanG<String> myStack = new MyStackJonathanG<>();

		String str =postfixExpr.replaceAll(" ", "");
		int character = 0;


		while(character < str.length()) {
			String token = getNextToken(postfixExpr, character);

			int temp = (int)token.charAt(0);// change token value to ANSII code
			// since we know the ANSI value of 0-9
			if(temp >=48 && temp<=57 ) {
				myStack.push(token);
			}
			else if(temp == 42||temp ==43||temp ==45|| temp == 47 || temp == 94) {
				String operand1 = myStack.pop();
				String operand2 = myStack.pop();
				String result = calc(token, operand2, operand1);
				myStack.push(result);

			}



			character++;
		}

		return Double.parseDouble(myStack.pop());
	}








	public static String calc(String operand, String operator1, String operator2 ) {
		String str = "";
		//int a = (int)operand.charAt(0);
		switch(operand) {

		case "+":
			double a = Double.parseDouble(operator1);
			double b = Double.parseDouble(operator2);
			double result = a+b;
			str = Double.toString(result);

			break;

		case "-":
			double c = Double.parseDouble(operator1);
			double d = Double.parseDouble(operator2);
			double result2 = c-d;
			str = Double.toString(result2);

			break;

		case "*":
			double e = Double.parseDouble(operator1);
			double f = Double.parseDouble(operator2);
			double result3 = e*f;
			str = Double.toString(result3);

			break;

		case "/":
			double g = Double.parseDouble(operator1);
			double h = Double.parseDouble(operator2);
			double result4 = g/h;
			str = Double.toString(result4);

			break;

		case "^":
			double i = Double.parseDouble(operator1);
			double j= Double.parseDouble(operator2);
			double result5 =  Math.pow(i, j);
			str = Double.toString(result5);

			break;


		}

		return str;

	}


	static String getNextToken(String infix, int character) {
		String str1;
		str1 = Character.toString(infix.charAt(character));
		return str1;
	}
}
