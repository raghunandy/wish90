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

    private final UserMoment userMoment;


    @Inject
    public SaveContactMoment(UserMoment userMoment, ThreadExecutor threadExecutor,
                             PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userMoment = userMoment;

        final String birthdayMoment = "BIRTHDAY";
        final String celebrationMoment = "CELEBRATION";
        final String anniversaryMoment = "ANNIVERSARY";

        for(String str: userMoment.getMommentType()) {
            if(str.trim().contains(birthdayMoment)){
                userMoment.setRefContact(userMoment.getRefContact());
                userMoment.setMomentDateTime(userMoment.getMomentDateTime());
                userMoment.setCustomized(userMoment.isCustomized());
            }
            else if (str.trim().contains(celebrationMoment)) {
                userMoment.setRefContact(userMoment.getRefContact());
                userMoment.setMomentDateTime(userMoment.getMomentDateTime());
                userMoment.setCustomized(userMoment.isCustomized());
            }
            else if (str.trim().contains(anniversaryMoment))
                userMoment.setRefContact(userMoment.getRefContact());
                userMoment.setMomentDateTime(userMoment.getMomentDateTime());
                userMoment.setCustomized(userMoment.isCustomized());
        }
    }

    @Override public Observable buildUseCaseObservable() {
        return null;

    }
}
