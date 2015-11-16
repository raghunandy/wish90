
package leona.gygafun.wish90.data.repository.datasource;

import leona.gygafun.wish90.data.cache.UserCache;
import leona.gygafun.wish90.data.cache.UserMomentCache;
import leona.gygafun.wish90.data.entity.UserEntity;
import leona.gygafun.wish90.data.entity.UserMomentEntity;

import java.util.List;

import rx.Observable;

/**
 * {@link UserDataStore} implementation based on file system data store.
 */
public class DiskUserDataStore implements UserDataStore {

    private final UserMomentCache userMomentCache;

    /**
     * Construct a {@link UserDataStore} based file system data store.
     *
     * @param userMomentCache A {@link userMomentCache} to cache data retrieved from the api.
     */
    public DiskUserDataStore(UserMomentCache userMomentCache) {
        this.userMomentCache = userMomentCache;
    }

    /**
     *  implement simple cache for storing/retrieving collections of users.
     * @return
     */
    @Override
    public Observable<List<UserEntity>> userEntityList() {
        return null;

    }

    @Override
    public Observable<UserEntity> userEntityDetails(final int user_id) {
      return null;
      //  return this.userMomentCache.get(user_id);
    }

    @Override
    public Observable<List<UserMomentEntity>> userMomentEntityList() {
        return userMomentCache.getAll();
    }

    @Override
    public Observable<UserMomentEntity> userMomentEntityDetails(int momentID) {
        return null;
    }

    @Override
    public Observable<UserMomentEntity> save(UserMomentEntity userMomentEntity) {
        userMomentCache.put(userMomentEntity);
        return null;
    }
}