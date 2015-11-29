/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.presentation.presenter;

import android.support.annotation.NonNull;

import leona.gygafun.wish90.domain.exception.ErrorBundle;
import leona.gygafun.wish90.domain.interactor.SaveContactMoment;
import leona.gygafun.wish90.domain.interactor.UseCase;
import leona.gygafun.wish90.presentation.exception.ErrorMessageFactory;
import leona.gygafun.wish90.presentation.di.PerActivity;
import leona.gygafun.wish90.presentation.model.UserMomentModel;
import leona.gygafun.wish90.presentation.view.UserMomentDetailsView;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
@PerActivity
public class UserMomentDetailsPresenter implements Presenter {

  /** id used to retrieve user details */
  private UserMomentModel userMomentModel;

  private UserMomentDetailsView viewDetailsView;





  private SaveContactMoment saveContactMoment;


  @Inject
  public UserMomentDetailsPresenter(@Named("saveContactMoment") SaveContactMoment saveContactMoment) {
    this.saveContactMoment=saveContactMoment;
  }

  public void saveUserMoment(){
    saveContactMoment.execute(null);

  }
  public void setView(@NonNull UserMomentDetailsView view) {
    this.viewDetailsView = view;
  }

  @Override public void resume() {}

  @Override public void pause() {}

  @Override public void destroy() {

  }

  /**
   * Initializes the presenter by start retrieving user details.
   */
  public void initialize(UserMomentModel userMomentModel) {
    this.userMomentModel = userMomentModel;
    this.loadMomentDetails();
  }

  /**
   * Loads user details.
   */
  private void loadMomentDetails() {
    this.hideViewRetry();
    this.viewDetailsView.renderUser(userMomentModel);

//    this.showViewLoading();

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

}
