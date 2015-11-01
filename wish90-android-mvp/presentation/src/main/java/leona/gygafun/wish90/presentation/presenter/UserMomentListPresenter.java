/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.presentation.presenter;

import android.support.annotation.NonNull;

import leona.gygafun.wish90.data.entity.UserMomentEntity;
import leona.gygafun.wish90.domain.UserMoment;
import leona.gygafun.wish90.domain.exception.DefaultErrorBundle;
import leona.gygafun.wish90.domain.exception.ErrorBundle;
import leona.gygafun.wish90.domain.interactor.DefaultSubscriber;
import leona.gygafun.wish90.domain.interactor.UseCase;
import leona.gygafun.wish90.presentation.exception.ErrorMessageFactory;
import leona.gygafun.wish90.presentation.di.PerActivity;
import leona.gygafun.wish90.presentation.mapper.UserModelDataMapper;
import leona.gygafun.wish90.presentation.model.UserMomentModel;
import leona.gygafun.wish90.presentation.view.UserMomentListView;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
@PerActivity
public class UserMomentListPresenter extends DefaultSubscriber<List<UserMomentEntity>> implements Presenter {

  private UserMomentListView viewListView;

  private final UseCase getUserListUseCase;
  private final UserModelDataMapper userModelDataMapper;

  @Inject
  public UserMomentListPresenter(@Named("userMomentList") UseCase getUserListUserCase, UserModelDataMapper userModelDataMapper) {
    this.getUserListUseCase = getUserListUserCase;
    this.userModelDataMapper = userModelDataMapper;
  }

  public void setView(@NonNull UserMomentListView view) {
    this.viewListView = view;
  }

  @Override public void resume() {}

  @Override public void pause() {}

  @Override public void destroy() {
    this.getUserListUseCase.unsubscribe();
  }

  /**
   * Initializes the presenter by start retrieving the user list.
   */
  public void initialize() {
    this.loadUserList();
  }

  /**
   * Loads all users.
   */
  private void loadUserList() {
    this.hideViewRetry();
    this.showViewLoading();
    this.getUserList();
  }

  public void onUserClicked(UserMomentModel userModel) {
    this.viewListView.viewUser(userModel);
  }

  private void showViewLoading() {
    this.viewListView.showLoading();
  }

  private void hideViewLoading() {
    this.viewListView.hideLoading();
  }

  private void showViewRetry() {
    this.viewListView.showRetry();
  }

  private void hideViewRetry() {
    this.viewListView.hideRetry();
  }

  private void showErrorMessage(ErrorBundle errorBundle) {
    String errorMessage = ErrorMessageFactory.create(this.viewListView.getContext(),
        errorBundle.getException());
    this.viewListView.showError(errorMessage);
  }

  private void showUsersCollectionInView(Collection<UserMoment> usersCollection) {
    final Collection<UserMomentModel> userModelsCollection =
        this.userModelDataMapper.transformMoment(usersCollection);
    this.viewListView.renderUserList(userModelsCollection);
  }

  private void getUserList() {
    this.getUserListUseCase.execute(new UserListSubscriber());
  }

  private final class UserListSubscriber extends DefaultSubscriber<List<UserMoment>> {

    @Override public void onCompleted() {
      UserMomentListPresenter.this.hideViewLoading();
    }

    @Override public void onError(Throwable e) {
      UserMomentListPresenter.this.hideViewLoading();
      UserMomentListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
      UserMomentListPresenter.this.showViewRetry();
    }

    @Override public void onNext(List<UserMoment> users) {
      UserMomentListPresenter.this.showUsersCollectionInView(users);
    }
  }
}
