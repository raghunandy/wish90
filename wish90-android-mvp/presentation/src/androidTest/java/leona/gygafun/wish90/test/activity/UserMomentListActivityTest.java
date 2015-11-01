/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.test.activity;

import android.app.Fragment;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import leona.gygafun.wish90.presentation.R;
import leona.gygafun.wish90.presentation.view.activity.UserMomentListActivity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserMomentListActivityTest extends ActivityInstrumentationTestCase2<UserMomentListActivity> {

  private UserMomentListActivity userListActivity;

  public UserMomentListActivityTest() {
    super(UserMomentListActivity.class);
  }

  @Override protected void setUp() throws Exception {
    super.setUp();
    this.setActivityIntent(createTargetIntent());
    userListActivity = getActivity();
  }

  @Override protected void tearDown() throws Exception {
    super.tearDown();
  }

  public void testContainsUserListFragment() {
    Fragment userListFragment =
        userListActivity.getFragmentManager().findFragmentById(R.id.fragmentUserList);
    assertThat(userListFragment, is(notNullValue()));
  }

  public void testContainsProperTitle() {
    String actualTitle = this.userListActivity.getTitle().toString().trim();

    assertThat(actualTitle, is("Users List"));
  }

  private Intent createTargetIntent() {
    Intent intentLaunchActivity =
        UserMomentListActivity.getCallingIntent(getInstrumentation().getTargetContext());

    return intentLaunchActivity;
  }
}
