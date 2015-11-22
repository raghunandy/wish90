/**
 * Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
 *
 */
package leona.gygafun.wish90.presentation.view.fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import butterknife.Bind;
import butterknife.BindDrawable;
import butterknife.ButterKnife;
import butterknife.OnClick;
import leona.gygafun.wish90.presentation.R;

import leona.gygafun.wish90.presentation.di.components.UserComponent;
import leona.gygafun.wish90.presentation.model.UserMomentModel;
import leona.gygafun.wish90.presentation.presenter.UserMomentListPresenter;
import leona.gygafun.wish90.presentation.view.UserMomentListView;
import leona.gygafun.wish90.presentation.view.activity.NewMomentActivity;
import leona.gygafun.wish90.presentation.view.adapter.UserMomentsAdapter;
import leona.gygafun.wish90.presentation.view.adapter.UserMomentsLayoutManager;

import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;

/**
 * Fragment that shows a moment list of Users.
 *
 * Place-folder 1: Venky & Irene
 *
 */
public class UserMomentListFragment extends BaseFragment implements UserMomentListView {

  /**
   * Interface for listening user list events.
   */
  public interface UserListListener {
    void onUserClicked(final UserMomentModel userModel);
  }

  @Inject
  UserMomentListPresenter userMomentListPresenter;

  @Bind(R.id.user_moments) RecyclerView user_moments;
  @Bind(R.id.rl_progress) RelativeLayout rl_progress;
  @Bind(R.id.rl_retry) RelativeLayout rl_retry;
  @Bind(R.id.bt_retry) Button bt_retry;
  @Bind(R.id.fab)
  FloatingActionButton newMoment;

  private UserMomentsAdapter usersAdapter;
  private UserMomentsLayoutManager usersLayoutManager;

  private UserListListener userListListener;

  public UserMomentListFragment() { super(); }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    if (activity instanceof UserListListener) {
      this.userListListener = (UserListListener) activity;
    }
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View fragmentView = inflater.inflate(R.layout.fragment_user_moment_list, container, true);
    ButterKnife.bind(this, fragmentView);
    setupUI();

    return fragmentView;
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    this.initialize();
    this.loadUserList();
  }

  @Override public void onResume() {
    super.onResume();
    this.userMomentListPresenter.resume();
  }

  @Override public void onPause() {
    super.onPause();
    this.userMomentListPresenter.pause();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    this.userMomentListPresenter.destroy();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }

  @BindDrawable(R.drawable.bg2)
  Drawable bg2;

  @Bind(R.id.mm_list_layout)
  RelativeLayout mmListLayout;

  private void initialize() {
    this.getComponent(UserComponent.class).inject(this);
    this.userMomentListPresenter.setView(this);
  }

  @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
  private void setupUI() {
    this.usersLayoutManager = new UserMomentsLayoutManager(getActivity());
    this.user_moments.setLayoutManager(usersLayoutManager);

    this.usersAdapter = new UserMomentsAdapter(getActivity(), new ArrayList<UserMomentModel>());
    this.usersAdapter.setOnItemClickListener(onItemClickListener);
    this.user_moments.setAdapter(usersAdapter);

  }

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

  @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
  @Override public void renderUserList(Collection<UserMomentModel> userModelCollection) {
    if (userModelCollection != null) {
        this.usersAdapter.setUserMomentCollection(userModelCollection);
    }

  }

  @Override public void viewUser(UserMomentModel userModel) {
    if (this.userListListener != null) {
      this.userListListener.onUserClicked(userModel);
    }

  }

  @Override public void showError(String message) {
    this.showToastMessage(message);
  }

  @Override public Context getContext() {
    return this.getActivity().getApplicationContext();
  }

  /**
   * Loads all users.
   */
  private void loadUserList() {
    this.userMomentListPresenter.initialize();
  }

  @OnClick(R.id.bt_retry) void onButtonRetryClick() {
    UserMomentListFragment.this.loadUserList();
  }

  private UserMomentsAdapter.OnItemClickListener onItemClickListener =
      new UserMomentsAdapter.OnItemClickListener() {
        @Override public void onUserItemClicked(UserMomentModel userModel) {
            if (UserMomentListFragment.this.userMomentListPresenter != null && userModel != null) {
              UserMomentListFragment.this.userMomentListPresenter.onUserClicked(userModel);
            }
        }
      };

  @OnClick(R.id.fab)  public void fabOnClickListener(){
    Intent intent;
    intent = new Intent(newMoment.getContext(), NewMomentActivity.class);

    newMoment.getContext().startActivity(intent);
  }


}
