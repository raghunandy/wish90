/**
 * Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
 *
 */
package leona.gygafun.wish90.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import leona.gygafun.wish90.presentation.R;
import leona.gygafun.wish90.presentation.di.components.UserComponent;
import leona.gygafun.wish90.presentation.model.UserMomentModel;
import leona.gygafun.wish90.presentation.presenter.UserMomentDetailsPresenter;
import leona.gygafun.wish90.presentation.util.TextUtil;
import leona.gygafun.wish90.presentation.view.UserMomentDetailsView;
import leona.gygafun.wish90.presentation.view.component.AutoLoadImageView;
import javax.inject.Inject;

/**
 * Fragment that shows details of a certain user.
 */
public class UserMomentMomentDetailsFragment extends BaseFragment implements UserMomentDetailsView {

  private static final String ARGUMENT_KEY_USER_MOMENT = "org.android10.ARGUMENT_USER_MOMENT";

  private UserMomentModel userMomentModel;

  @Inject
  UserMomentDetailsPresenter userMomentDetailsPresenter;

  @Bind(R.id.contact_name) TextView contactName;

  public UserMomentMomentDetailsFragment() {  }

  public static UserMomentMomentDetailsFragment newInstance(UserMomentModel userMomentModel) {
    UserMomentMomentDetailsFragment userMomentDetailsFragment = new UserMomentMomentDetailsFragment();

    Bundle argumentsBundle = new Bundle();
    argumentsBundle.putSerializable(ARGUMENT_KEY_USER_MOMENT, userMomentModel);
    userMomentDetailsFragment.setArguments(argumentsBundle);

    return userMomentDetailsFragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View fragmentView = inflater.inflate(R.layout.fragment_user_moment_details, container, false);
    ButterKnife.bind(this, fragmentView);

    return fragmentView;
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    this.initialize();
  }

  @Override public void onResume() {
    super.onResume();
    this.userMomentDetailsPresenter.resume();
  }

  @Override public void onPause() {
    super.onPause();
    this.userMomentDetailsPresenter.pause();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    this.userMomentDetailsPresenter.destroy();
  }

  private void initialize() {
    this.getComponent(UserComponent.class).inject(this);
    this.userMomentDetailsPresenter.setView(this);
    this.userMomentModel = (UserMomentModel)getArguments().getSerializable(ARGUMENT_KEY_USER_MOMENT);
    this.userMomentDetailsPresenter.initialize(this.userMomentModel);
  }

  @Override public void renderUser(UserMomentModel userMomentModel) {
    if (userMomentModel != null) {
      contactName.setText(TextUtil.makeStringCamelCase(userMomentModel.getRefContact().getContactName()));
    }
  }

  @Override
  public void showLoading() {

  }

  @Override
  public void hideLoading() {

  }

  @Override
  public void showRetry() {

  }

  @Override
  public void hideRetry() {

  }

  @Override public void showError(String message) {
    this.showToastMessage(message);
  }

  @Override public Context getContext() {
    return getActivity().getApplicationContext();
  }

  /**
   * Loads all users.
   */
  private void loadUserDetails() {
    if (this.userMomentDetailsPresenter != null) {
      this.userMomentDetailsPresenter.initialize(this.userMomentModel);
    }
  }




//  @OnClick(R.id.bt_retry)
//  void onButtonRetryClick() {
//    UserMomentMomentDetailsFragment.this.loadUserDetails();
//  }
}
