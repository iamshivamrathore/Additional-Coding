package stacksAndqueue;

import java.util.EmptyStackException;

public class MyStack<T> {

	private static class StackNode<T> {
		private T data;
		StackNode<T> next;

		StackNode(T data) {
			this.data = data;
		}

		public String toString() {
			return data + " ";
		}
	}

	private StackNode<T> top;

	void push(T data) {
		StackNode<T> node = new StackNode<T>(data);
		if (top == null) {
			top = node;
		} else {
			node.next = top;
			top = node;
		}
	}

	T pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		T item = top.data;
		top = top.next;
		return item;
	}

	void display() {
		StackNode<T> current = top;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

	@Override
	public String toString() {
		return "MyStack [top=" + top + "]";
	}

	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<>();
		stack.push(10);
		System.out.println(stack);
		stack.push(20);
		System.out.println(stack);
		stack.display();
	}

}
