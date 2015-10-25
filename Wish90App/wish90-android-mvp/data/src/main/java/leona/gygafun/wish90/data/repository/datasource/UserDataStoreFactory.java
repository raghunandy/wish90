
package leona.gygafun.wish90.data.repository.datasource;

import android.content.Context;

import leona.gygafun.wish90.data.cache.UserCache;
import leona.gygafun.wish90.data.entity.mapper.UserEntityJsonMapper;
import leona.gygafun.wish90.data.net.RestApi;
import leona.gygafun.wish90.data.net.RestApiImpl;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link UserDataStore}.
 */
@Singleton
public class UserDataStoreFactory {

    private final Context context;
    private final UserCache userCache;

    @Inject
    public UserDataStoreFactory(Context context, UserCache userCache) {
        if (context == null || userCache == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();
        this.userCache = userCache;
    }

    /**
     * Create {@link UserDataStore} from a user id.
     */
    public UserDataStore create(int userId) {
        UserDataStore userDataStore;

        if (!this.userCache.isExpired() && this.userCache.isCached(userId)) {
            userDataStore = new DiskUserDataStore(this.userCache);
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
        RestApi restApi = new RestApiImpl(this.context, userEntityJsonMapper);

        return new CloudUserDataStore(restApi, this.userCache);
    }
}
