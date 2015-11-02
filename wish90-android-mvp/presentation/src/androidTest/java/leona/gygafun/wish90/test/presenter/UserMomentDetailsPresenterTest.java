/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.test.presenter;

import android.content.Context;
import android.test.AndroidTestCase;

import leona.gygafun.wish90.presentation.mapper.UserModelDataMapper;
import leona.gygafun.wish90.presentation.model.UserMomentModel;
import leona.gygafun.wish90.presentation.presenter.UserMomentDetailsPresenter;
import leona.gygafun.wish90.presentation.view.UserMomentDetailsView;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rx.Subscriber;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class UserMomentDetailsPresenterTest extends AndroidTestCase {

  private static final UserMomentModel FAKE_USER_MOMENT = new UserMomentModel();

  private UserMomentDetailsPresenter userMomentDetailsPresenter;

  @Mock
  private Context mockContext;
  @Mock
  private UserMomentDetailsView mockUserMomentDetailsView;

  @Mock
  private UserModelDataMapper mockUserModelDataMapper;

  @Override protected void setUp() throws Exception {
    super.setUp();
    MockitoAnnotations.initMocks(this);
    userMomentDetailsPresenter = new UserMomentDetailsPresenter();
    userMomentDetailsPresenter.setView(mockUserMomentDetailsView);
  }

  public void testUserDetailsPresenterInitialize() {
    given(mockUserMomentDetailsView.getContext()).willReturn(mockContext);

    userMomentDetailsPresenter.initialize(FAKE_USER_MOMENT);

    verify(mockUserMomentDetailsView).hideRetry();
    verify(mockUserMomentDetailsView).showLoading();
    //verify(mockGetUserDetails).execute(any(Subscriber.class));
  }
}
