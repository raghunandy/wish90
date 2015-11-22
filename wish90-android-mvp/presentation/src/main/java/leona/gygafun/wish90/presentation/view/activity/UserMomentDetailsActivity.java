/**
 * Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
 *
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
import leona.gygafun.wish90.presentation.di.modules.UserMomentModule;
import leona.gygafun.wish90.presentation.model.UserMomentModel;
import leona.gygafun.wish90.presentation.view.fragment.UserMomentMomentDetailsFragment;

/**
 * Activity that shows details of a certain user.
 */
public class UserMomentDetailsActivity extends BaseActivity implements HasComponent<UserComponent> {

  private static final String INTENT_EXTRA_PARAM_USER_MOMENT_OBJECT = "org.android10.INTENT_PARAM_USER_MOMENT_OBJECT";
  private static final String INSTANCE_STATE_PARAM_USER_ID = "org.android10.STATE_PARAM_USER_ID";

  private UserMomentModel userMomentModel;
  private UserComponent userComponent;

  public static Intent getCallingIntent(Context context, UserMomentModel userMomentModel) {
    Intent callingIntent = new Intent(context, UserMomentDetailsActivity.class);
    callingIntent.putExtra(INTENT_EXTRA_PARAM_USER_MOMENT_OBJECT, userMomentModel);

    return callingIntent;
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_user_details);

    this.initializeActivity(savedInstanceState);
    this.initializeInjector();
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    if (outState != null) {
      outState.putSerializable(INSTANCE_STATE_PARAM_USER_ID, this.userMomentModel);
    }
    super.onSaveInstanceState(outState);
  }

  /**
   * Initializes this activity.
   */
  private void initializeActivity(Bundle savedInstanceState) {
    if (savedInstanceState == null) {
      this.userMomentModel = (UserMomentModel)getIntent().getSerializableExtra(INTENT_EXTRA_PARAM_USER_MOMENT_OBJECT);
      addFragment(R.id.fl_fragment, UserMomentMomentDetailsFragment.newInstance(this.userMomentModel));
    } else {
      this.userMomentModel = (UserMomentModel) savedInstanceState.getSerializable(INSTANCE_STATE_PARAM_USER_ID);
    }
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
}
