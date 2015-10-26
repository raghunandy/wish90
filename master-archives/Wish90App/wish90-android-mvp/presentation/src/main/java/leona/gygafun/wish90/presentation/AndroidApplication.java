/* Wish90 */
package leona.gygafun.wish90.presentation;

import android.app.Application;
import leona.gygafun.wish90.presentation.di.components.ApplicationComponent;
import leona.gygafun.wish90.presentation.di.components.DaggerApplicationComponent;
import leona.gygafun.wish90.presentation.di.modules.ApplicationModule;

/**
 * Android Main Application
 */
public class AndroidApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    this.initializeInjector();
  }

  private void initializeInjector() {
    this.applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }

  public ApplicationComponent getApplicationComponent() {
    return this.applicationComponent;
  }
}
