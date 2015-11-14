/**
 * Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
 */
package leona.gygafun.wish90.data.entity.mapper;

import leona.gygafun.wish90.data.entity.UserEntity;
import leona.gygafun.wish90.data.entity.UserMomentEntity;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class used to transform from Strings representing json to valid objects.
 */
@Singleton
public class UserEntityJsonMapper {

    private final Gson gson;

    @Inject
    public UserEntityJsonMapper() {
        this.gson = new Gson();
    }

    /**
     * Transform from valid json string to {@link UserEntity}.
     *
     * @param userJsonResponse A json representing a user profile.
     * @return {@link UserEntity}.
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    public UserEntity transformUserEntity(String userJsonResponse) throws JsonSyntaxException {
        try {
            Type userEntityType = new TypeToken<UserEntity>() {
            }.getType();
            UserEntity userEntity = this.gson.fromJson(userJsonResponse, userEntityType);

            return userEntity;
        } catch (JsonSyntaxException jsonException) {
            throw jsonException;
        }
    }

    /**
     * Transform from valid json string to List of {@link UserEntity}.
     *
     * @param userListJsonResponse A json representing a collection of users.
     * @return List of {@link UserEntity}.
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    public List<UserEntity> transformUserEntityCollection(String userListJsonResponse)
            throws JsonSyntaxException {

        List<UserEntity> userEntityCollection;
        try {
            Type listOfUserEntityType = new TypeToken<List<UserEntity>>() {
            }.getType();
            userEntityCollection = this.gson.fromJson(userListJsonResponse, listOfUserEntityType);

            return userEntityCollection;
        } catch (JsonSyntaxException jsonException) {
            throw jsonException;
        }
    }




    /**
     * Transform from valid json string to {@link UserEntity}.
     *
     * @param userJsonResponse A json representing a user profile.
     * @return {@link UserEntity}.
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    public UserMomentEntity transformUserMomentEntity(String userJsonResponse) throws JsonSyntaxException {
        try {
            Type UserMomentEntityType = new TypeToken<UserMomentEntity>() {
            }.getType();
            UserMomentEntity UserMomentEntity = this.gson.fromJson(userJsonResponse, UserMomentEntityType);

            return UserMomentEntity;
        } catch (JsonSyntaxException jsonException) {
            throw jsonException;
        }
    }

    /**
     * Transform from valid json string to List of {@link UserMomentEntity}.
     *
     * @param userListJsonResponse A json representing a collection of users.
     * @return List of {@link UserMomentEntity}.
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    public List<UserMomentEntity> transformUserMomentEntityCollection(String userListJsonResponse)
            throws JsonSyntaxException {

        List<UserMomentEntity> UserMomentEntityCollection;
        try {
            Type listOfUserMomentEntityType = new TypeToken<List<UserMomentEntity>>() {
            }.getType();
            UserMomentEntityCollection = this.gson.fromJson(userListJsonResponse, listOfUserMomentEntityType);

            return UserMomentEntityCollection;
        } catch (JsonSyntaxException jsonException) {
            throw jsonException;
        }
    }
}
