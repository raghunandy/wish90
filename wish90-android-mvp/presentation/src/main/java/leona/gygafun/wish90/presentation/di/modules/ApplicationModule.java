/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.presentation.di.modules;

import android.content.Context;
import leona.gygafun.wish90.data.cache.UserCache;
import leona.gygafun.wish90.data.cache.UserCacheImpl;
import leona.gygafun.wish90.data.cache.UserMomentCache;
import leona.gygafun.wish90.data.cache.UserMomentCacheImpl;
import leona.gygafun.wish90.data.executor.JobExecutor;
import leona.gygafun.wish90.data.repository.UserDataRepository;
import leona.gygafun.wish90.domain.executor.PostExecutionThread;
import leona.gygafun.wish90.domain.executor.ThreadExecutor;
import leona.gygafun.wish90.domain.repository.UserRepository;
import leona.gygafun.wish90.presentation.AndroidApplication;
import leona.gygafun.wish90.presentation.UIThread;
import leona.gygafun.wish90.presentation.navigation.Navigator;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
  private final AndroidApplication application;

  public ApplicationModule(AndroidApplication application) {
    this.application = application;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return this.application;
  }

  @Provides @Singleton Navigator provideNavigator() {
    return new Navigator();
  }

  @Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }

  @Provides @Singleton UserCache provideUserCache(UserCacheImpl userCache) {
    return userCache;
  }

  @Provides @Singleton UserRepository provideUserRepository(UserDataRepository userDataRepository) {
    return userDataRepository;
  }

  @Provides @Singleton UserMomentCache provideUserMomentCache(UserMomentCacheImpl userMomentCache) {
    return userMomentCache;
  }
}
