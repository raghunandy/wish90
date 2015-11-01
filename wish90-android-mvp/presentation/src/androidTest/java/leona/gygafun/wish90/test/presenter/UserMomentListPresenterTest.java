/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.test.presenter;

import android.content.Context;
import android.test.AndroidTestCase;
import leona.gygafun.wish90.domain.interactor.GetUserMomentList;
import leona.gygafun.wish90.presentation.mapper.UserModelDataMapper;
import leona.gygafun.wish90.presentation.presenter.UserMomentListPresenter;
import leona.gygafun.wish90.presentation.view.UserMomentListView;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rx.Subscriber;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class UserMomentListPresenterTest extends AndroidTestCase {

  private UserMomentListPresenter userMomentListPresenter;

  @Mock
  private Context mockContext;
  @Mock
  private UserMomentListView mockUserMomentListView;
  @Mock
  private GetUserMomentList mockGetUserMomentList;
  @Mock
  private UserModelDataMapper mockUserModelDataMapper;

  @Override protected void setUp() throws Exception {
    super.setUp();
    MockitoAnnotations.initMocks(this);
    userMomentListPresenter = new UserMomentListPresenter(mockGetUserMomentList, mockUserModelDataMapper);
    userMomentListPresenter.setView(mockUserMomentListView);
  }

  public void testUserListPresenterInitialize() {
    given(mockUserMomentListView.getContext()).willReturn(mockContext);

    userMomentListPresenter.initialize();

    verify(mockUserMomentListView).hideRetry();
    verify(mockUserMomentListView).showLoading();
    verify(mockGetUserMomentList).execute(any(Subscriber.class));
  }
}
