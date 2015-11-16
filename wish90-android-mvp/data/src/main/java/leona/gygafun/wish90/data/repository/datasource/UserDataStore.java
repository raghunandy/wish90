
package leona.gygafun.wish90.data.repository.datasource;

import leona.gygafun.wish90.data.entity.UserEntity;

import java.util.List;

import leona.gygafun.wish90.data.entity.UserMomentEntity;
import leona.gygafun.wish90.domain.UserMoment;
import rx.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface UserDataStore {
    /**
     * Get an {@link rx.Observable} which will emit a List of {@link UserEntity}.
     */
    Observable<List<UserEntity>> userEntityList();

    /**
     * Get an {@link rx.Observable} which will emit a {@link UserEntity} by its id.
     *
     * @param userId The id to retrieve user data.
     */
    Observable<UserEntity> userEntityDetails(final int userId);

    /**
     * Get an {@link rx.Observable} which will emit a List of {@link UserMomentEntity}.
     */
    Observable<List<UserMomentEntity>> userMomentEntityList();

    /**
     * Get an {@link rx.Observable} which will emit a {@link UserMomentEntity} by its id.
     *
     * @param momentID The id to retrieve user data.
     */

    Observable<UserMomentEntity> userMomentEntityDetails(final int momentID);
    Observable<UserMomentEntity> save(final UserMomentEntity userMomentEntity);
}
