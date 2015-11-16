
package leona.gygafun.wish90.data.repository.datasource;

import leona.gygafun.wish90.data.cache.UserCache;
import leona.gygafun.wish90.data.entity.UserEntity;
import leona.gygafun.wish90.data.entity.UserMomentEntity;
import leona.gygafun.wish90.data.MomentApi;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * {@link UserDataStore} implementation based on connections to the api (Cloud).
 */
public class CloudUserDataStore implements UserDataStore {

    private final MomentApi momentApi;
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
     * @param momentApi The {@link MomentApi} implementation to use.
     * @param userCache A {@link UserCache} to cache data retrieved from the api.
     */
    public CloudUserDataStore(MomentApi momentApi, UserCache userCache) {
        this.momentApi = momentApi;
        this.userCache = userCache;
    }


    @Override
    public Observable<List<UserEntity>> userEntityList() {
        return null;
//        return this.momentApi.userMomentEntityList();
    }


    public Observable<UserEntity> userEntityDetails(final int userId) {
        return null;
//        return this.momentApi.userEntityById(userId)
//                .doOnNext(saveToCacheAction);
    }

    @Override
    public Observable<List<UserMomentEntity>> userMomentEntityList() {
        return this.momentApi.userMomentEntityList();
    }

    @Override
    public Observable<UserMomentEntity> userMomentEntityDetails(int momentID) {
        return null;
    }

    @Override
    public Observable<UserMomentEntity> save(UserMomentEntity userMomentEntity) {
//        ../
        return null;
    }
}
