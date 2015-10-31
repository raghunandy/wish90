/* Wish90 */
package leona.gygafun.wish90.presentation.di.components;

import leona.gygafun.wish90.presentation.di.PerActivity;
import leona.gygafun.wish90.presentation.di.modules.ActivityModule;
import leona.gygafun.wish90.presentation.di.modules.UserModule;
import leona.gygafun.wish90.presentation.view.fragment.UserMomentDetailsFragment;
import leona.gygafun.wish90.presentation.view.fragment.UserMomentListFragment;
import dagger.Component;

/**
 * A scope {@link leona.gygafun.wish90.presentation.di.PerActivity} component.
 * Injects user specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent extends ActivityComponent {
  void inject(UserMomentListFragment userListFragment);
  void inject(UserMomentDetailsFragment userMomentDetailsFragment);
}
