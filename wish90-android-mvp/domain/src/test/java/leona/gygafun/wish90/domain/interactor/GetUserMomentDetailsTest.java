/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.domain.interactor;

import leona.gygafun.wish90.domain.executor.PostExecutionThread;
import leona.gygafun.wish90.domain.executor.ThreadExecutor;

import leona.gygafun.wish90.domain.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

public class GetUserMomentDetailsTest {

  private static final int FAKE_USER_ID = 123;

  private GetUserMomentDetails getUserDetails;

  @Mock private UserRepository mockUserRepository;
  @Mock private ThreadExecutor mockThreadExecutor;
  @Mock private PostExecutionThread mockPostExecutionThread;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    getUserDetails = new GetUserMomentDetails(FAKE_USER_ID, mockUserRepository,
        mockThreadExecutor, mockPostExecutionThread);
  }

  @Test
  public void testGetUserDetailsUseCaseObservableHappyCase() {
    getUserDetails.buildUseCaseObservable();

    verify(mockUserRepository).user(FAKE_USER_ID);
    verifyNoMoreInteractions(mockUserRepository);
    verifyZeroInteractions(mockPostExecutionThread);
    verifyZeroInteractions(mockThreadExecutor);
  }
}
