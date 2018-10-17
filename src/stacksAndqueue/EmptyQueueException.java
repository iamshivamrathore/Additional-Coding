package stacksAndqueue;

public class EmptyQueueException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyQueueException() {
		// TODO Auto-generated constructor stub
		System.out.println("Default");
	}

	public EmptyQueueException(String s) {
		System.out.println("String" + s);
	}

}
