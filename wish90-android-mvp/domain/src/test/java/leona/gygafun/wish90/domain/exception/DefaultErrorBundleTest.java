/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.domain.exception;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class DefaultErrorBundleTest {
  private leona.gygafun.wish90.domain.exception.DefaultErrorBundle defaultErrorBundle;

  @Mock
  private Exception mockException;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    defaultErrorBundle = new leona.gygafun.wish90.domain.exception.DefaultErrorBundle(mockException);
  }

  @Test
  public void testGetErrorMessageInteraction() {
    defaultErrorBundle.getErrorMessage();

    verify(mockException).getMessage();
  }
}