/*Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-) 1 -) 6) + (5 -) 9 -) 2) .Thatis,617 + 295.
Output: 2 -) 1 -) 9. That is, 912.*/

package linkedlist;

public class SumLists {

	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.insert(1);
		head1.insert(6);

		Node head2 = new Node(5);
		head2.insert(9);
		head2.insert(2);

		Node head3 = add(head1, head2);
		head3.display();
		Node rev = head3.reverse();
		rev.display();
	}

	private static Node add(Node head1, Node head2) {

		Node num1 = head1;
		Node num2 = head2;
		Node num3 = null;
		int carry = 0;

		while (num1 != null && num2 != null) {
			int add = num1.data + num2.data + carry;
			if (num3 == null) {
				num3 = new Node(add % 10);
			}else {
				num3.insert(add%10);
			}
			carry = add/10;
			num1 = num1.next;
			num2 = num2.next;
		}
		return num3;
	}

}
