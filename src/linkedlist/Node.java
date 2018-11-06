//Basic Node class with associated functions to implement Linked Lists

package linkedlist;

public class Node {

	
	int num;
	Node next;

	Node(int num) {
		this.num = num;
		this.next = null;
	}

	Node(){
		
	}
	void insert(Node node) {
		
		
		Node curr = this;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = node;
	}

	void insert(int num) {
		
		
		Node node = new Node(num);
		Node curr = this;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = node;
	}

	void display() {
		System.out.print("List : ");
		Node curr = this;
		while (curr != null) {
			System.out.print(curr.num + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	Node reverse() {
		Node head2 = new Node();
		head2.num = this.num;
		
		Node curr = this.next;
		while(curr != null) {
			Node num2 = new Node();
			num2.num = curr.num;
			num2.next = head2;
			head2 = num2;
			curr = curr.next;
		}
		return head2;
	}
	public String toString() {
		return num + " ";
	}
}
