/**
 * Wish 90
 * updated by rkrasniqi
 *
 */
package leona.gygafun.wish90.presentation.view;

import leona.gygafun.wish90.presentation.model.UserModel;
import leona.gygafun.wish90.presentation.model.UserMomentModel;

import java.util.Collection;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a list of {@link UserModel}.
 */
public interface UserListView extends LoadDataView {
  /**
   * Render a user list in the UI.
   *
   * @param userModelCollection The collection of {@link UserModel} that will be shown.
   */
  void renderUserList(Collection<UserMomentModel> userModelCollection);

  /**
   * View a {@link UserModel} profile/details.
   *
   * @param userModel The user that will be shown.
   */
  void viewUser(UserMomentModel userModel);
}
