// Class:		CS 5040
// Term:		Fall 2022
// Name:		Jonathan J. Gomez
// Program Number:	Assignment 3 - Part 1
// IDE: 		Eclipse, JDK 15.0.1




public class MyStackJonathanG <E> {

	E[] data;
	int size;
	int top;
	final int MAX_SIZE = 30;


	public MyStackJonathanG() {
		size = 0;
		top = -1;
		data = (E[])new Object[MAX_SIZE];
	}

	public E push(E newElement){
		if(size != MAX_SIZE) {
			top ++;
			data[top] = newElement;
			size ++;
			return newElement;
		}
		else {
			throw new RuntimeException("Push method: Stack is full!");
		}

	}

	public E pop(){
		if(!isEmpty()) {
			size--;
			return data[top--];
		}
		else {
			throw new RuntimeException("Pop method: Stack is empty");
		}
	}
	
	
	public E peek() throws RuntimeException{
		if(!isEmpty()) {
			return data[top];
		}
		else {
			throw new RuntimeException("Peek method: Stack is empty");
		}

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}
	
	public String toString() {
		String str = "[";
		for(int i = 0; i<size; i++) {
			
			str = str + data[i];
			if(i<size-1)
				str = str + ", ";
		}


			return str + "]";
	}


}
