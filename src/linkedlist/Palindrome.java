/*Palindrome: Implement a function to check if a linked list is a palindrome.*/

package linkedlist;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node head1 = new Node(1);
		head1.insert(2);
		head1.insert(2);


		Node head2 = head1.reverse();

		System.out.println(isPalindrome(head1, head2));
	}

	private static boolean isPalindrome(Node head1, Node head2) {
		Node curr1 = head1;
		Node curr2 = head2;
		while (curr1 != null && curr2 != null) {
			if (curr1.data != curr2.data) {
				return false;
			}
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		return true;
	}

}
