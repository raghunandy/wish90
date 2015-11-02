/**
 * Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
 *
 */
package leona.gygafun.wish90.presentation.view;

import leona.gygafun.wish90.presentation.model.UserModel;
import leona.gygafun.wish90.presentation.model.UserMomentModel;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a user profile.
 */
public interface UserMomentDetailsView extends LoadDataView {
  /**
   * Render a user in the UI.
   *
   * @param user The {@link UserModel} that will be shown.
   */
  void renderUser(UserMomentModel user);
}
