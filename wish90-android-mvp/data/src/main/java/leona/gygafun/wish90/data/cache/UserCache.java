/**
 Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
 */
package leona.gygafun.wish90.data.cache;

import leona.gygafun.wish90.data.entity.UserEntity;
import leona.gygafun.wish90.data.entity.UserMomentEntity;

import rx.Observable;

/**
 * An interface representing a user Cache.
 */
public interface UserCache {
    /**
     * Gets an {@link rx.Observable} which will emit a {@link UserEntity}.
     *
     * @param userId The user id to retrieve data.
     */
     Observable<UserEntity> get(final int userId);

    /**
     * Puts and element into the cache.
     *
     * @param userEntity Element to insert in the cache.
     */
    void put(UserEntity userEntity);

    /**
     * Checks if an element (User) exists in the cache.
     *
     * @param userId The id used to look for inside the cache.
     * @return true if the element is cached, otherwise false.
     */
    boolean isCached(final int userId);



    /**
     * Gets an {@link rx.Observable} which will emit a {@link UserEntity}.
     *
     * @param userId The user id to retrieve data.
     */
   // Observable<UserMomentEntity> getMoment(final int userId);

    /**
     * Puts and element into the cache.
     *
     * @param userEntity Element to insert in the cache.
     */
  //  void put(UserMomentEntity userEntity);


    /**
     * Checks if the cache is expired.
     *
     * @return true, the cache is expired, otherwise false.
     */
    boolean isExpired();

    /**
     * Evict all elements of the cache.
     */
    void evictAll();
}
