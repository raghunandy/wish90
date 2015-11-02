/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */

//Created by: rkrasniqi

package leona.gygafun.wish90.presentation.mapper;

import leona.gygafun.wish90.domain.User;
import leona.gygafun.wish90.domain.UserMoment;
import leona.gygafun.wish90.domain.ConveySchedule;

import leona.gygafun.wish90.presentation.di.PerActivity;
import leona.gygafun.wish90.presentation.model.ContactModel;
import leona.gygafun.wish90.presentation.model.UserModel;
import leona.gygafun.wish90.presentation.model.UserMomentModel;
import leona.gygafun.wish90.presentation.model.ConveyScheduleModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.inject.Inject;

/**
 * Mapper class used to transform {@link User} (in the domain layer) to {@link UserModel} in the
 * presentation layer.
 */
@PerActivity
public class UserModelDataMapper {

  @Inject
  public UserModelDataMapper() {}

  /**
   * Transform a {@link User} into an {@link UserModel}.
   *
   * @param user Object to be transformed.
   * @return {@link UserModel}.
   */
  public UserModel transform(User user) {
    if (user == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    UserModel userModel = new UserModel(user.getUserID());
    userModel.setUsername(user.getUsername());
    userModel.setPassword(user.getPassword());
    userModel.setUserEmailAddress(user.getUserEmailAddress());
    userModel.setoAuthToken(user.getoAuthToken());
    userModel.setCurrentSignInDate(user.getCurrentSignInDate());
    userModel.setLastSignInDate(user.getLastSignInDate());
    userModel.setUserAccessCount(user.getUserAccessCount());

    return userModel;
  }

  /**
   * Transform a Collection of {@link User} into a Collection of {@link UserModel}.
   *
   * @param usersCollection Objects to be transformed.
   * @return List of {@link UserModel}.
   */
  public Collection<UserModel> transform(Collection<User> usersCollection) {
    Collection<UserModel> userModelsCollection;

    if (usersCollection != null && !usersCollection.isEmpty()) {
      userModelsCollection = new ArrayList<>();
      for (User user : usersCollection) {
        userModelsCollection.add(transform(user));
      }
    } else {
      userModelsCollection = Collections.emptyList();
    }

    return userModelsCollection;
  }

  /**
   * Transform a {@link UserMoment} into an {@link UserMomentModel}.
   *
   * @param userMoment Object to be transformed.
   * @return {@link UserMomentModel}.
   */
  public UserMomentModel transformMoment(UserMoment userMoment) {
    if (userMoment == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    UserMomentModel userMomentModel = new UserMomentModel();
    userMomentModel.setMomentID(userMoment.getMomentID());
    userMomentModel.setUserID(userMoment.getUserID());
    userMomentModel.setMommentType(userMoment.getMommentType());
    userMomentModel.setMomentDateTime(userMoment.getMomentDateTime());
    userMomentModel.setCustomized(userMoment.isCustomized());
    userMomentModel.setConfigurations(userMoment.getConfigurations());
    userMomentModel.setRefContact(new ContactModel(userMoment.getRefContact().getContactName(),userMoment.getRefContact().getContactImage()));

    return userMomentModel;
  }

  public Collection<UserMomentModel> transformMoment(Collection<UserMoment> userMomentCollection) {
    Collection<UserMomentModel> userMomentModelsCollection;

    if (userMomentCollection != null && !userMomentCollection.isEmpty()) {
      userMomentModelsCollection = new ArrayList<>();
      for (UserMoment userMoment : userMomentCollection) {
        userMomentModelsCollection.add(transformMoment(userMoment));
      }
    } else {
      userMomentModelsCollection = Collections.emptyList();
    }

    return userMomentModelsCollection;
  }




  public ConveyScheduleModel transformSchedule(ConveySchedule conveySchedule) {
    if (conveySchedule == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    ConveyScheduleModel conveyScheduleModel = new ConveyScheduleModel(conveySchedule.getScheduleID());
    conveyScheduleModel.setMomentID(conveySchedule.getMomentID());
    conveyScheduleModel.setScheduleInstrument(conveySchedule.getScheduleInstrument());
    conveyScheduleModel.setTemplate(conveySchedule.getTemplate());
    conveyScheduleModel.setDeliverInstrument(conveySchedule.getDeliverInstrument());

    return conveyScheduleModel;
  }

  /**
   * Transform a Collection of {@link ConveySchedule} into a Collection of {@link ConveyScheduleModel}.
   *
   * @param conveyScheduleCollection Objects to be transformed.
   * @return List of {@link ConveyScheduleModel}.
   */
  public Collection<ConveyScheduleModel> transformSchedule(Collection<ConveySchedule> conveyScheduleCollection) {
    Collection<ConveyScheduleModel> conveyScheduleModelCollection;

    if (conveyScheduleCollection != null && !conveyScheduleCollection.isEmpty()) {
      conveyScheduleModelCollection = new ArrayList<>();
      for (ConveySchedule conveySchedule : conveyScheduleCollection) {
        conveyScheduleModelCollection.add(transformSchedule(conveySchedule));
      }
    } else {
      conveyScheduleModelCollection = Collections.emptyList();
    }

    return conveyScheduleModelCollection;
  }
}
