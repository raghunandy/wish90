/**
 Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
 */
package leona.gygafun.wish90.data.cache;

import java.util.List;

import leona.gygafun.wish90.data.entity.UserEntity;
import leona.gygafun.wish90.data.entity.UserMomentEntity;
import rx.Observable;

/**
 * An interface representing a user Cache.
 */
public interface UserMomentCache extends  DefaultFileCache {
    /**
     * Gets an {@link Observable} which will emit a {@link UserMomentEntity}.
     *
     *
     */
    Observable<List<UserMomentEntity>> getAll();

    /**
     * Puts and element into the cache.
     *
     * @param userMomentEntity Element to insert in the cache.
     */
    void put(UserMomentEntity userMomentEntity);





}
