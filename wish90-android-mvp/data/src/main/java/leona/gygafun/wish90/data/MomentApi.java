/**
  Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
 */
package leona.gygafun.wish90.data;

import leona.gygafun.wish90.data.entity.UserEntity;

import java.util.List;

import leona.gygafun.wish90.data.entity.UserMomentEntity;
import rx.Observable;

/**
 * MomentApi for retrieving data from the network.
 */
public interface MomentApi {

  /**
   * Retrieves an {@link Observable} which will emit a List of {@link UserEntity}.
   */
  Observable<List<UserMomentEntity>> userMomentEntityList();

  /**
   * Retrieves an {@link Observable} which will emit a {@link UserEntity}.
   *
   * @param userId The user id used to get user data.
   */
  Observable<UserMomentEntity> userEntityById(final int userId);
}
