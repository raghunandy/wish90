
package leona.gygafun.wish90.data.repository.datasource;

import leona.gygafun.wish90.data.cache.UserCache;
import leona.gygafun.wish90.data.entity.UserEntity;
import leona.gygafun.wish90.data.entity.UserMomentEntity;
import leona.gygafun.wish90.data.net.RestApi;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * {@link UserDataStore} implementation based on connections to the api (Cloud).
 */
public class CloudUserDataStore implements UserDataStore {

    private final RestApi restApi;
    private final UserCache userCache;

    private final Action1<UserEntity> saveToCacheAction =
            userEntity -> {
                if (userEntity != null) {
                    CloudUserDataStore.this.userCache.put(userEntity);
                }
            };

    /**
     * Construct a {@link UserDataStore} based on connections to the api (Cloud).
     *
     * @param restApi The {@link RestApi} implementation to use.
     * @param userCache A {@link UserCache} to cache data retrieved from the api.
     */
    public CloudUserDataStore(RestApi restApi, UserCache userCache) {
        this.restApi = restApi;
        this.userCache = userCache;
    }


    @Override
    public Observable<List<UserEntity>> userEntityList() {
        return null;
//        return this.restApi.userMomentEntityList();
    }


    public Observable<UserEntity> userEntityDetails(final int userId) {
        return null;
//        return this.restApi.userEntityById(userId)
//                .doOnNext(saveToCacheAction);
    }

    @Override
    public Observable<List<UserMomentEntity>> userMomentEntityList() {
        return this.restApi.userMomentEntityList();
    }

    @Override
    public Observable<UserMomentEntity> userMomentEntityDetails(int momentID) {
        return null;
    }


}
