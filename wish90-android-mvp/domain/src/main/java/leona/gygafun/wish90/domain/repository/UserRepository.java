/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.domain.repository;

import leona.gygafun.wish90.domain.User;
import java.util.List;

import leona.gygafun.wish90.domain.UserMoment;
import rx.Observable;

/**
 * Interface that represents a Repository for getting {@link User} related data.
 */
public interface UserRepository {


  /**
   * Get an {@link rx.Observable} which will emit a {@link User}.
   *
   * @param userId The user id used to retrieve user data.
   */
  Observable<User> user(int userId);


  /**
   * Get an {@link rx.Observable} which will emit a List of {@link User}.
   */
  Observable<List<UserMoment>> userMoments();

  /**
   * Get an {@link rx.Observable} which will emit a {@link User}.
   *
   * @param userId The user id used to retrieve user data.
   */
  Observable<UserMoment> userMoment(int userId);


  Observable<UserMoment> saveUserMoment(UserMoment userMoment);


}
