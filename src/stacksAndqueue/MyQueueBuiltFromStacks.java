//Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.

package stacksAndqueue;

import java.util.Stack;

public class MyQueueBuiltFromStacks<T> {

	Stack<T> s1;
	Stack<T> s2;

	public MyQueueBuiltFromStacks() {

		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	void push(T data) {
		
		if(s1.isEmpty()) {
			s1.push(data);
			return;
		}
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		System.out.println("This : "+this);
		s1.push(data);
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}

	T pop() throws EmptyQueueException {
		if (s1.isEmpty()) {
			throw new EmptyQueueException();

		}
		return s1.pop();
		


	}

	@Override
	public String toString() {
		return "MyQueueBuiltFromStacks [s1=" + s1 + ", s2=" + s2 + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyQueueBuiltFromStacks<Integer> ob = new MyQueueBuiltFromStacks<>();
		
	//	Random r = new Random();
		for(int i=0;i<10;i++) {

			System.out.println("Pushing: "+i);
			ob.push(i);
			System.out.println(ob);
		}
		
		System.out.println(ob);
	}

}
