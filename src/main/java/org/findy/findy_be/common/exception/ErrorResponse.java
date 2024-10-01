package org.findy.findy_be.common.exception;

public record ErrorResponse(
	String error,
	int status,
	String message
) {

	public static ErrorResponse of(final String error, final int status, final String message) {
		return new ErrorResponse(error, status, message);
	}
}