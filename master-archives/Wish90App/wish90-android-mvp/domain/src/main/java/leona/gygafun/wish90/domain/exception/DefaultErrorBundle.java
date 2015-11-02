/* Wish90 
* updated by: rkrasniqi
*/
package leona.gygafun.wish90.domain.exception;

/**
 *  Wrapper around Exceptions used to manage default errors.
 */
public class DefaultErrorBundle implements ErrorBundle {

  private static final String DEFAULT_ERROR_MSG = "Unknown error";

  private final Exception exception;

  public DefaultErrorBundle(Exception exception) {
    this.exception = exception;
  }

  @Override
  public Exception getException() {
    return this.exception;
  }

  @Override
  public String getErrorMessage() {
    return (this.exception != null) ? this.exception.getMessage() : DEFAULT_ERROR_MSG;
  }
}
