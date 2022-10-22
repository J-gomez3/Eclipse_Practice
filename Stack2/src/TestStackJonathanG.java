// Class:		CS 5040
// Term:		Fall 2022
// Name:		Jonathan J. Gomez
// Program Number:	Assignment 3 - Part 1 (Tester)
// IDE: 		Eclipse, JDK 15.0.1


public class TestStackJonathanG {

	public static void main(String[] args) {
	MyStackJonathanG<String> myStack = new MyStackJonathanG<>(); 
	
	//----------------Method is Empty
	System.out.println("Empty = " +  myStack.isEmpty());
	
	
	
	//---------------Method Push--------------
	myStack.push("A");
	myStack.push("B");
	myStack.push("*");
	System.out.println(myStack);
	System.out.println("Empty after pushing to stack = " +  myStack.isEmpty());
	
	//----------------myStack.size()----------------------
	System.out.println("Size = " +  myStack.size());
	System.out.println("myStack = " + myStack);
	
	
	
	//---------------myStack.pop()----------------
	myStack.pop();
	myStack.pop();
	
	
	
	//=-------------myStack.peek()--------
	//System.out.println("Pop or removed the following: " + myStack.pop());
	System.out.println("Peek the following <E>: " + myStack.peek());
	System.out.println("Peek the following <E>: " + myStack.peek());
	
	//----------myStack.toString()-----------------
	System.out.println("toString = " +  myStack.toString());
	//System.out.println(myStack.pop());
	//System.out.println(myStack.peek());
	//System.out.println(myStack.pop());

	
	
	
	}
	
}
