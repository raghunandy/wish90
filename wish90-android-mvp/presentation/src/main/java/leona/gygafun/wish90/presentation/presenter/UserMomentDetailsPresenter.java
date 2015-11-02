/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.presentation.presenter;

import android.support.annotation.NonNull;
import leona.gygafun.wish90.domain.User;
import leona.gygafun.wish90.domain.exception.DefaultErrorBundle;
import leona.gygafun.wish90.domain.exception.ErrorBundle;
import leona.gygafun.wish90.domain.interactor.DefaultSubscriber;
import leona.gygafun.wish90.domain.interactor.UseCase;
import leona.gygafun.wish90.presentation.exception.ErrorMessageFactory;
import leona.gygafun.wish90.presentation.di.PerActivity;
import leona.gygafun.wish90.presentation.mapper.UserModelDataMapper;
import leona.gygafun.wish90.presentation.model.UserModel;
import leona.gygafun.wish90.presentation.view.UserDetailsView;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
@PerActivity
public class UserMomentDetailsPresenter implements Presenter {

  /** id used to retrieve user details */
  private int userId;

  private UserDetailsView viewDetailsView;

  private final UseCase getUserDetailsUseCase;
  private final UserModelDataMapper userModelDataMapper;

  @Inject
  public UserMomentDetailsPresenter(@Named("userDetails") UseCase getUserDetailsUseCase,
                                    UserModelDataMapper userModelDataMapper) {
    this.getUserDetailsUseCase = getUserDetailsUseCase;
    this.userModelDataMapper = userModelDataMapper;
  }

  public void setView(@NonNull UserDetailsView view) {
    this.viewDetailsView = view;
  }

  @Override public void resume() {}

  @Override public void pause() {}

  @Override public void destroy() {
    this.getUserDetailsUseCase.unsubscribe();
  }

  /**
   * Initializes the presenter by start retrieving user details.
   */
  public void initialize(int userId) {
    this.userId = userId;
    this.loadUserDetails();
  }

  /**
   * Loads user details.
   */
  private void loadUserDetails() {
    this.hideViewRetry();
    this.showViewLoading();
    this.getUserDetails();
  }

  private void showViewLoading() {
    this.viewDetailsView.showLoading();
  }

  private void hideViewLoading() {
    this.viewDetailsView.hideLoading();
  }

  private void showViewRetry() {
    this.viewDetailsView.showRetry();
  }

  private void hideViewRetry() {
    this.viewDetailsView.hideRetry();
  }

  private void showErrorMessage(ErrorBundle errorBundle) {
    String errorMessage = ErrorMessageFactory.create(this.viewDetailsView.getContext(),
        errorBundle.getException());
    this.viewDetailsView.showError(errorMessage);
  }

  private void showUserDetailsInView(User user) {
    final UserModel userModel = this.userModelDataMapper.transform(user);
    //this.viewDetailsView.renderUser(userModel);
  }

  private void getUserDetails() {
    this.getUserDetailsUseCase.execute(new UserDetailsSubscriber());
  }

  private final class UserDetailsSubscriber extends DefaultSubscriber<User> {

    @Override public void onCompleted() {
      UserMomentDetailsPresenter.this.hideViewLoading();
    }

    @Override public void onError(Throwable e) {
      UserMomentDetailsPresenter.this.hideViewLoading();
      UserMomentDetailsPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
      UserMomentDetailsPresenter.this.showViewRetry();
    }

    @Override public void onNext(User user) {
      UserMomentDetailsPresenter.this.showUserDetailsInView(user);
    }
  }
}