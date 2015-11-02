/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.test.activity;

import android.app.Fragment;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import leona.gygafun.wish90.presentation.R;
import leona.gygafun.wish90.presentation.model.UserMomentModel;
import leona.gygafun.wish90.presentation.view.activity.UserMomentDetailsActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class UserMomentDetailsActivityTest extends ActivityInstrumentationTestCase2<UserMomentDetailsActivity> {

  private static final UserMomentModel FAKE_USER_MODULE = new UserMomentModel();

  private UserMomentDetailsActivity userMomentDetailsActivity;

  public UserMomentDetailsActivityTest() {
    super(UserMomentDetailsActivity.class);
  }

  @Override protected void setUp() throws Exception {
    super.setUp();
    this.setActivityIntent(createTargetIntent());
    this.userMomentDetailsActivity = getActivity();
  }

  @Override protected void tearDown() throws Exception {
    super.tearDown();
  }

  public void testContainsUserDetailsFragment() {
    Fragment userDetailsFragment =
        userMomentDetailsActivity.getFragmentManager().findFragmentById(R.id.fl_fragment);
    assertThat(userDetailsFragment, is(notNullValue()));
  }

  public void testContainsProperTitle() {
    String actualTitle = this.userMomentDetailsActivity.getTitle().toString().trim();

    assertThat(actualTitle, is("User Details"));
  }

  public void testLoadUserHappyCaseViews() {
    onView(withId(R.id.rl_retry)).check(matches(not(isDisplayed())));
    onView(withId(R.id.rl_progress)).check(matches(not(isDisplayed())));

//    onView(withId(R.id.tv_fullname)).check(matches(isDisplayed()));
//    onView(withId(R.id.tv_email)).check(matches(isDisplayed()));
//    onView(withId(R.id.tv_description)).check(matches(isDisplayed()));
  }

  public void testLoadUserHappyCaseData() {
//    onView(withId(R.id.tv_fullname)).check(matches(withText("John Sanchez")));
//    onView(withId(R.id.tv_email)).check(matches(withText("dmedina@katz.edu")));
//    onView(withId(R.id.tv_followers)).check(matches(withText("4523")));
  }

  private Intent createTargetIntent() {
    Intent intentLaunchActivity =
        UserMomentDetailsActivity.getCallingIntent(getInstrumentation().getTargetContext(), FAKE_USER_MODULE);

    return intentLaunchActivity;
  }
}
