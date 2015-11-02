/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.presentation.navigation;

import android.content.Context;
import android.content.Intent;

import leona.gygafun.wish90.presentation.model.UserMomentModel;
import leona.gygafun.wish90.presentation.view.activity.UserMomentDetailsActivity;
import leona.gygafun.wish90.presentation.view.activity.UserMomentListActivity;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class used to navigate through the application.
 */
@Singleton
public class Navigator {

  @Inject
  public void Navigator() {
    //empty
  }

  /**
   * Goes to the user list screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToUserList(Context context) {
    if (context != null) {
      Intent intentToLaunch = UserMomentListActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

  /**
   * Goes to the user details screen.
   *
   * @param context A Context needed to open the destiny activity.
   */
  public void navigateToUserMomentDetails(Context context,UserMomentModel userMomentModel) {
    if (context != null) {
      Intent intentToLaunch = UserMomentDetailsActivity.getCallingIntent(context, userMomentModel);
      context.startActivity(intentToLaunch);
    }
  }
}
