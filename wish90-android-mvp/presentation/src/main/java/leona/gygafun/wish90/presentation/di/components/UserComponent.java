/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.presentation.di.components;

import leona.gygafun.wish90.presentation.di.PerActivity;
import leona.gygafun.wish90.presentation.di.modules.ActivityModule;
import leona.gygafun.wish90.presentation.di.modules.UserMomentModule;
import leona.gygafun.wish90.presentation.view.fragment.UserMomentMomentDetailsFragment;
import leona.gygafun.wish90.presentation.view.fragment.UserMomentListFragment;
import dagger.Component;

/**
 * A scope {@link leona.gygafun.wish90.presentation.di.PerActivity} component.
 * Injects user specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserMomentModule.class})
public interface UserComponent extends ActivityComponent {
  void inject(UserMomentListFragment userListFragment);
  void inject(UserMomentMomentDetailsFragment userMomentDetailsFragment);

}
