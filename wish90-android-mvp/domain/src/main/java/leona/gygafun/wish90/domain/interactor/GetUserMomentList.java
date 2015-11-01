/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.domain.interactor;

import leona.gygafun.wish90.domain.User;
import leona.gygafun.wish90.domain.executor.PostExecutionThread;
import leona.gygafun.wish90.domain.executor.ThreadExecutor;

import leona.gygafun.wish90.domain.repository.UserRepository;
import javax.inject.Inject;
import rx.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link User}.
 */
public class GetUserMomentList extends UseCase {

  private final UserRepository userRepository;

  @Inject
  public GetUserMomentList(UserRepository userRepository, ThreadExecutor threadExecutor,
                           PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.userRepository = userRepository;
  }

  @Override public Observable buildUseCaseObservable() {
    return this.userRepository.userMoments();
  }
}
