/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.data.exception;

import com.fernandocejas.android10.sample.data.ApplicationTestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class RepositoryErrorBundleTest extends ApplicationTestCase {

  private RepositoryErrorBundle repositoryErrorBundle;

  @Mock
  private Exception mockException;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    repositoryErrorBundle = new RepositoryErrorBundle(mockException);
  }

  @Test
  public void testGetErrorMessageInteraction() {
    repositoryErrorBundle.getErrorMessage();

    verify(mockException).getMessage();
  }
}
