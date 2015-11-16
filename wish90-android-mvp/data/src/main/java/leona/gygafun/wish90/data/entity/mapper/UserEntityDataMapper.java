/**
 * Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
 */

//Created by: rkrasniqi

package leona.gygafun.wish90.data.entity.mapper;

import leona.gygafun.wish90.data.entity.ContactEntity;
import leona.gygafun.wish90.data.entity.UserMomentEntity;
import leona.gygafun.wish90.data.entity.UserEntity;
import leona.gygafun.wish90.data.entity.ConveyScheduleEntity;

import leona.gygafun.wish90.domain.Contact;
import leona.gygafun.wish90.domain.User;
import leona.gygafun.wish90.domain.UserMoment;
import leona.gygafun.wish90.domain.ConveySchedule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link UserEntity} (in the data layer) to {@link User} in the
 * domain layer.
 */
@Singleton
public class UserEntityDataMapper {

    @Inject
    public UserEntityDataMapper() {
    }

    /**
     * Transform a {@link UserEntity} into an {@link User}.
     *
     * @param userEntity Object to be transformed.
     * @return {@link User} if valid {@link UserEntity} otherwise null.
     */
    public User transform(UserEntity userEntity) {
        User user = null;
        if (userEntity != null) {
            user = new User(userEntity.getUserID());
            user.setUsername(userEntity.getUsername());
            user.setPassword(userEntity.getPassword());
            user.setUserEmailAddress(userEntity.getUserEmailAddress());
            user.setoAuthToken(userEntity.getoAuthToken());
            user.setCurrentSignInDate(userEntity.getCurrentSignInDate());
            user.setLastSignInDate(userEntity.getLastSignInDate());
            user.setUserAccessCount(userEntity.getUserAccessCount());
        }

        return user;
    }



    /**
     * Transform a List of {@link UserEntity} into a Collection of {@link User}.
     *
     * @param userEntityCollection Object Collection to be transformed.
     * @return {@link User} if valid {@link UserEntity} otherwise null.
     */
    public List<User> transform(Collection<UserEntity> userEntityCollection) {
        List<User> userList = new ArrayList<>(20);
        User user;
        for (UserEntity userEntity : userEntityCollection) {
            user = transform(userEntity);
            if (user != null) {
                userList.add(user);
            }
        }
        return userList;
    }




    public UserMoment transformMoment(UserMomentEntity userMomentEntity) {
        UserMoment userMoment = null;
        if (userMomentEntity != null) {
            userMoment = new UserMoment(userMomentEntity.getUserID());
            userMoment.setMomentID(userMomentEntity.getMomentID());
            userMoment.setUserID(userMomentEntity.getUserID());
            userMoment.setMommentType(userMomentEntity.getMommentType());
            userMoment.setMomentDateTime(userMomentEntity.getMomentDateTime());
            userMoment.setCustomized(userMomentEntity.isCustomized());
            userMoment.setConfigurations(userMomentEntity.getConfigurations());
            ContactEntity c=userMomentEntity.getRefContact();
            userMoment.setRefContact(new Contact(c.getContactName(), c.getContactImage()));
        }

        return userMoment;
    }


    /**
     * Transform a List of {@link UserMomentEntity} into a Collection of {@link UserMoment}.
     *
     * @param userEntityCollection Object Collection to be transformed.
     * @return {@link UserMoment} if valid {@link UserMomentEntity} otherwise null.
     */
    public List<UserMoment> transformMoment(Collection<UserMomentEntity> userEntityCollection) {
        List<UserMoment> userMomentList = new ArrayList<>(20);
        UserMoment userMoment;
        for (UserMomentEntity userMomentEntity : userEntityCollection) {
            userMoment = transformMoment(userMomentEntity);
            if (userMoment != null) {
                userMomentList.add(userMoment);
            }
        }

        return userMomentList;
    }



    public ConveySchedule transformSchedule(ConveyScheduleEntity scheduleEntity) {
        ConveySchedule conveySchedule = null;
        if (scheduleEntity != null) {
            conveySchedule = new ConveySchedule(scheduleEntity.getScheduleID());
            conveySchedule.setScheduleID(scheduleEntity.getScheduleID());
            conveySchedule.setMomentID(scheduleEntity.getMomentID());
            conveySchedule.setScheduleInstrument(scheduleEntity.getScheduleInstrument());
            conveySchedule.setTemplate(scheduleEntity.getTemplate());
            conveySchedule.setDeliverInstrument(scheduleEntity.getDeliverInstrument());
        }
        return conveySchedule;
    }

    /**
     * Transform a List of {@link ConveyScheduleEntity} into a Collection of {@link ConveySchedule}.
     *
     * @param conveyScheduleEntityCollection Object Collection to be transformed.
     * @return {@link ConveySchedule} if valid {@link ConveyScheduleEntity} otherwise null.
     */
    public List<ConveySchedule> transformSchedule(Collection<ConveyScheduleEntity> conveyScheduleEntityCollection) {
        List<ConveySchedule> conveyScheduleList = new ArrayList<>(20);
        ConveySchedule conveySchedule;
        for (ConveyScheduleEntity conveyScheduleEntity : conveyScheduleEntityCollection) {
            conveySchedule = transformSchedule(conveyScheduleEntity);
            if (conveySchedule != null) {
                conveyScheduleList.add(conveySchedule);
            }
        }

        return conveyScheduleList;
    }

    /**
     *
     * @param userMoment
     * @return
     */
    //TODO
    public UserMomentEntity transformToEntity(UserMoment userMoment) {
        return null;
    }
}
