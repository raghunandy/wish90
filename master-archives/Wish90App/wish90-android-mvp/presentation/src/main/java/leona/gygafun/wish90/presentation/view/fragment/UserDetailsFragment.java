/**
 * Wish 90
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
import leona.gygafun.wish90.presentation.model.UserModel;
import leona.gygafun.wish90.presentation.presenter.UserDetailsPresenter;
import leona.gygafun.wish90.presentation.view.UserDetailsView;
import leona.gygafun.wish90.presentation.view.component.AutoLoadImageView;
import javax.inject.Inject;

/**
 * Fragment that shows details of a certain user.
 */
public class UserDetailsFragment extends BaseFragment implements UserDetailsView {

  private static final String ARGUMENT_KEY_USER_ID = "org.android10.ARGUMENT_USER_ID";

  private int userId;

  @Inject UserDetailsPresenter userDetailsPresenter;

  @Bind(R.id.iv_cover) AutoLoadImageView iv_cover;
  @Bind(R.id.tv_fullname) TextView tv_fullname;
  @Bind(R.id.tv_email) TextView tv_email;
  @Bind(R.id.tv_followers) TextView tv_followers;
  @Bind(R.id.tv_description) TextView tv_description;
  @Bind(R.id.rl_progress) RelativeLayout rl_progress;
  @Bind(R.id.rl_retry) RelativeLayout rl_retry;
  @Bind(R.id.bt_retry) Button bt_retry;

  public UserDetailsFragment() { super(); }

  public static UserDetailsFragment newInstance(int userId) {
    UserDetailsFragment userDetailsFragment = new UserDetailsFragment();

    Bundle argumentsBundle = new Bundle();
    argumentsBundle.putInt(ARGUMENT_KEY_USER_ID, userId);
    userDetailsFragment.setArguments(argumentsBundle);

    return userDetailsFragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View fragmentView = inflater.inflate(R.layout.fragment_user_details, container, false);
    ButterKnife.bind(this, fragmentView);

    return fragmentView;
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    this.initialize();
  }

  @Override public void onResume() {
    super.onResume();
    this.userDetailsPresenter.resume();
  }

  @Override public void onPause() {
    super.onPause();
    this.userDetailsPresenter.pause();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    this.userDetailsPresenter.destroy();
  }

  private void initialize() {
    this.getComponent(UserComponent.class).inject(this);
    this.userDetailsPresenter.setView(this);
    this.userId = getArguments().getInt(ARGUMENT_KEY_USER_ID);
    this.userDetailsPresenter.initialize(this.userId);
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
    if (this.userDetailsPresenter != null) {
      this.userDetailsPresenter.initialize(this.userId);
    }
  }

  @OnClick(R.id.bt_retry)
  void onButtonRetryClick() {
    UserDetailsFragment.this.loadUserDetails();
  }
}
