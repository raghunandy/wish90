/**
 * Wish90
 */
 //Created by: rkrasniqi
 
package leona.gygafun.wish90.data.exception;

import leona.gygafun.wish90.domain.exception.ErrorBundle;
/**
 * Wrapper around Exceptions used to manage errors in the repository.
 */
public class RepositoryErrorBundle implements ErrorBundle {

    private final Exception exception;

    public RepositoryErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return this.exception;
    }

    @Override
    public String getErrorMessage() {
        String message = "";
        if (this.exception != null) {
            this.exception.getMessage();
        }
        return message;
    }
}
