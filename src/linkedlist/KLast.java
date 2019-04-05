package linkedlist;

public class KLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(10);
		Node node1 = new Node(20);
		Node node2 = new Node(30);
		Node node3 = new Node(5);
		Node node4 = new Node(25);
		Node node5 = new Node(20);

		Node headNode = node;
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		headNode.display();

		findLast_K(headNode, 3);
	}

	static void findLast_K(Node n, int k) {
		Node behindNode = n;
		Node forwaNode = null;
		for (int i = 0; i < k; i++) {
			forwaNode = n;
			n = n.next;
		}
		
		System.out.println("Forward: "+forwaNode.data);
		System.out.println("Behind : "+behindNode.data);
		while(forwaNode.next!=null) {
			behindNode = behindNode.next;
			forwaNode = forwaNode.next;
			System.out.print("Forward: "+forwaNode.data);
			System.out.println("\tBehind : "+behindNode.data);
		}
		
		System.out.println("\n\nKth to last : "+behindNode.data);

	}

}
