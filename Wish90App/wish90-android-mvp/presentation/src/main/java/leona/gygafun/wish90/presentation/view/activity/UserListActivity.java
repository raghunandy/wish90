/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package leona.gygafun.wish90.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import leona.gygafun.wish90.presentation.R;
import leona.gygafun.wish90.presentation.di.HasComponent;
import leona.gygafun.wish90.presentation.di.components.DaggerUserComponent;
import leona.gygafun.wish90.presentation.di.components.UserComponent;
import leona.gygafun.wish90.presentation.model.UserModel;
import leona.gygafun.wish90.presentation.view.fragment.UserListFragment;

/**
 * Activity that shows a list of Users.
 */
public class UserListActivity extends BaseActivity implements HasComponent<UserComponent>,
    UserListFragment.UserListListener {

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, UserListActivity.class);
  }

  private UserComponent userComponent;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
    setContentView(R.layout.activity_user_list);

    this.initializeInjector();
  }

  private void initializeInjector() {
    this.userComponent = DaggerUserComponent.builder()
        .applicationComponent(getApplicationComponent())
        .activityModule(getActivityModule())
        .build();
  }

  @Override public UserComponent getComponent() {
    return userComponent;
  }

  @Override public void onUserClicked(UserModel userModel) {
    this.navigator.navigateToUserDetails(this, userModel.getUserId());
  }
}
