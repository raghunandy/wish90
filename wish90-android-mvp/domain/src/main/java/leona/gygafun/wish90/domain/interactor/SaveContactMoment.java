package leona.gygafun.wish90.domain.interactor;

/*************************************
 * Created by rkrasniqi on 11/15/15.
 *************************************/


import leona.gygafun.wish90.domain.executor.PostExecutionThread;
import leona.gygafun.wish90.domain.executor.ThreadExecutor;

import leona.gygafun.wish90.domain.repository.UserRepository;
import leona.gygafun.wish90.domain.UserMoment;
import javax.inject.Inject;
import rx.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link leona.gygafun.wish90.domain.UserMoment}.
 */

public class SaveContactMoment extends UseCase {


    private final UserRepository userRepository;

    private final UserMoment userMoment;
    @Inject
    public SaveContactMoment(UserMoment userMoment,UserRepository userRepository,ThreadExecutor threadExecutor,
                             PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userMoment=userMoment;
        this.userRepository=userRepository;

    }



    @Override public Observable buildUseCaseObservable() {
        return this.userRepository.saveUserMoment(this.userMoment);


    }
}
