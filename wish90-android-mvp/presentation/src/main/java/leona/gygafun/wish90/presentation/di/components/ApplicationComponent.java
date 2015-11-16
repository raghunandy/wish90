/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.presentation.di.components;

import android.content.Context;

import leona.gygafun.wish90.data.cache.UserMomentCache;
import leona.gygafun.wish90.domain.executor.PostExecutionThread;
import leona.gygafun.wish90.domain.executor.ThreadExecutor;
import leona.gygafun.wish90.domain.repository.UserRepository;
import leona.gygafun.wish90.presentation.di.modules.ApplicationModule;
import leona.gygafun.wish90.presentation.view.activity.BaseActivity;
import dagger.Component;
import javax.inject.Singleton;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
  void inject(BaseActivity baseActivity);

  //Exposed to sub-graphs.
  Context context();
  ThreadExecutor threadExecutor();
  PostExecutionThread postExecutionThread();
  UserRepository userRepository();
  UserMomentCache userMomentCache();

}
