package by.iba.exceptions;

public class NotEnoughProductsException extends Exception {

	private static final long serialVersionUID = -1344934730462343246L;

	private String message;

	public NotEnoughProductsException(String message) {
		this.message = message;
	}
	
	public void writeMessage() {
		System.out.println(this.message);
	}
}
