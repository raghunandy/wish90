
package leona.gygafun.wish90.data.repository.datasource;

import android.content.Context;

import leona.gygafun.wish90.data.cache.UserCache;
import leona.gygafun.wish90.data.cache.UserMomentCache;
import leona.gygafun.wish90.data.entity.mapper.UserEntityJsonMapper;
import leona.gygafun.wish90.data.MomentApi;
import leona.gygafun.wish90.data.external.MomentMobileApiImpl;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link UserDataStore}.
 */
@Singleton
public class UserDataStoreFactory {

    private final Context context;
    private final UserCache userCache;
    private final UserMomentCache userMomentCache;

    @Inject
    public UserDataStoreFactory(Context context, UserCache userCache,UserMomentCache userMomentCache) {
        if (context == null || userCache == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();
        this.userCache = userCache;
        this.userMomentCache=userMomentCache;
    }

    /**
     * Create {@link UserDataStore} from a user id.
     */
    public UserDataStore create(int userId) {
        UserDataStore userDataStore;

        if (!this.userCache.isExpired() && this.userCache.isCached(userId)) {
            userDataStore = new DiskUserDataStore(this.userMomentCache);
        } else {
            userDataStore = createCloudDataStore();
        }

        return userDataStore;
    }

    /**
     * Create {@link UserDataStore} to retrieve data from the Cloud.
     */
    public UserDataStore createCloudDataStore() {
        UserEntityJsonMapper userEntityJsonMapper = new UserEntityJsonMapper();
        MomentApi momentApi = new MomentMobileApiImpl(this.context, userEntityJsonMapper);

        return new CloudUserDataStore(momentApi, this.userCache);
    }

    public UserDataStore createCacheDataStore() {
        return new DiskUserDataStore(this.userMomentCache);
    }
}
