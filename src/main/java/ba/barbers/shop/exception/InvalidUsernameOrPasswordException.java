package ba.barbers.shop.exception;

public class InvalidUsernameOrPasswordException extends RuntimeException {

  public InvalidUsernameOrPasswordException() {
    super();
  }


  public InvalidUsernameOrPasswordException(final String message) {
    super(message);
  }


  public InvalidUsernameOrPasswordException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public InvalidUsernameOrPasswordException(final Throwable cause) {
    super(cause);
  }


}
