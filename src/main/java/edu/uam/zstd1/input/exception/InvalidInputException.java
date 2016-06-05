package edu.uam.zstd1.input.exception;

/**
 * Created by mmanski
 */
public class InvalidInputException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidInputException(String message, Throwable t) {
		super(message, t);
	}
}
