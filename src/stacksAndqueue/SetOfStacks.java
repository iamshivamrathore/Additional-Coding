package stacksAndqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks<T> {

	int size;
	int threshold;

	List<Stack<T>> list;
	Stack<T> currentStack;

	SetOfStacks(int threshold) {

		this.threshold = threshold;
		size = 0;
		list = new LinkedList<>();
	}

	void push(T data) {

		if (size % threshold == 0) {
			currentStack = new Stack<>();
			list.add(currentStack);
		}
		list.get(size / threshold).push(data);
		size++;
		currentStack.toString();
		// System.out.println(this);

	}

	T pop() {
		Stack<T> stack;
		System.out.print("Before In Pop: " + this);
		if (size % threshold == 0) {
			stack = list.get(((size / threshold)) - 1);
		} else {
			// System.out.println("Index : " + ((int) Math.ceil((size / threshold)) - 1));
			stack = list.get(((size / threshold)));
		}

		T item = stack.pop();
		System.out.print("\tAfter In Pop: " + this);
		// System.out.println("In Pop: "+this);
		size--;
		
		if(size%threshold == 0) {
			list.remove(size/threshold);
		}
		return item;
	}

	@Override
	public String toString() {
		return "SetOfStacks [list=" + list + "]\t" + "Size : " + size;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SetOfStacks<Integer> stacks = new SetOfStacks<Integer>(3);
		for (int i = 0; i < 9; i++) {
			System.out.println("Pushing : " + i);
			stacks.push(i);
		}
		System.out.println(stacks);
		for (int i = 0; i < 9; i++) {
			System.out.println("Popped : " + stacks.pop());
		}
		for (int i = 0; i < 9; i++) {
			System.out.println("Pushing : " + i);
			stacks.push(i);
		}
		System.out.println(stacks);
	}

}
