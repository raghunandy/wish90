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
import leona.gygafun.wish90.presentation.presenter.UserMomentDetailsPresenter;
import leona.gygafun.wish90.presentation.view.UserDetailsView;
import leona.gygafun.wish90.presentation.view.component.AutoLoadImageView;
import javax.inject.Inject;

/**
 * Fragment that shows details of a certain user.
 */
public class UserMomentDetailsFragment extends BaseFragment implements UserDetailsView {

  private static final String ARGUMENT_KEY_USER_ID = "org.android10.ARGUMENT_USER_ID";

  private int userId;

  @Inject
  UserMomentDetailsPresenter userMomentDetailsPresenter;

  @Bind(R.id.iv_cover) AutoLoadImageView iv_cover;
  @Bind(R.id.tv_fullname) TextView tv_fullname;
  @Bind(R.id.tv_email) TextView tv_email;
  @Bind(R.id.tv_followers) TextView tv_followers;
  @Bind(R.id.tv_description) TextView tv_description;
  @Bind(R.id.rl_progress) RelativeLayout rl_progress;
  @Bind(R.id.rl_retry) RelativeLayout rl_retry;
  @Bind(R.id.bt_retry) Button bt_retry;

  public UserMomentDetailsFragment() { super(); }

  public static UserMomentDetailsFragment newInstance(int userId) {
    UserMomentDetailsFragment userMomentDetailsFragment = new UserMomentDetailsFragment();

    Bundle argumentsBundle = new Bundle();
    argumentsBundle.putInt(ARGUMENT_KEY_USER_ID, userId);
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
    this.userId = getArguments().getInt(ARGUMENT_KEY_USER_ID);
    this.userMomentDetailsPresenter.initialize(this.userId);
  }
/*
  @Override public void renderUser(UserModel user) {
    if (user != null) {
      this.iv_cover.setImageUrl(user.getCoverUrl());
      this.tv_fullname.setText(user.getFullName());
      this.tv_email.setText(user.getEmail());
      this.tv_followers.setText(String.valueOf(user.getFollowers()));
      this.tv_description.setText(user.getDescription());
    }
  }
*/
  @Override public void showLoading() {
    this.rl_progress.setVisibility(View.VISIBLE);
    this.getActivity().setProgressBarIndeterminateVisibility(true);
  }

  @Override public void hideLoading() {
    this.rl_progress.setVisibility(View.GONE);
    this.getActivity().setProgressBarIndeterminateVisibility(false);
  }

  @Override public void showRetry() {
    this.rl_retry.setVisibility(View.VISIBLE);
  }

  @Override public void hideRetry() {
    this.rl_retry.setVisibility(View.GONE);
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
      this.userMomentDetailsPresenter.initialize(this.userId);
    }
  }

  @OnClick(R.id.bt_retry)
  void onButtonRetryClick() {
    UserMomentDetailsFragment.this.loadUserDetails();
  }
}