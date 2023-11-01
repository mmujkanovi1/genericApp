package ba.barbers.shop.exception;

public class AuthTokenMissingException extends RuntimeException {
  public AuthTokenMissingException() {
    super();
  }

  public AuthTokenMissingException(final String message) {
    super(message);
  }

  public AuthTokenMissingException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public AuthTokenMissingException(final Throwable cause) {
    super(cause);
  }
}
