/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.presentation.di.modules;

import leona.gygafun.wish90.domain.executor.PostExecutionThread;
import leona.gygafun.wish90.domain.executor.ThreadExecutor;

import leona.gygafun.wish90.domain.interactor.GetUserMomentList;
import leona.gygafun.wish90.domain.interactor.SaveContactMoment;
import leona.gygafun.wish90.domain.interactor.UseCase;
import leona.gygafun.wish90.domain.repository.UserRepository;
import leona.gygafun.wish90.presentation.di.PerActivity;
import dagger.Module;
import dagger.Provides;
import leona.gygafun.wish90.presentation.model.UserMomentModel;

import javax.inject.Named;

/**
 * Dagger module that provides user related collaborators.
 */
@Module
public class UserMomentModule {

  private UserMomentModel userMomentModel = new UserMomentModel();

  public UserMomentModule() {}

  public UserMomentModule(UserMomentModel userMomentModel) {
    this.userMomentModel = userMomentModel;
  }


  @Provides @PerActivity @Named("userMomentList") UseCase provideGetUserListUseCase(
      GetUserMomentList getUserMomentList) {
    return getUserMomentList;
  }


    @Provides @PerActivity @Named("saveContactMoment") UseCase provideSaveContactMomentUseCase(
            SaveContactMoment getSaveContactMoment) {
        return getSaveContactMoment;
    }
}