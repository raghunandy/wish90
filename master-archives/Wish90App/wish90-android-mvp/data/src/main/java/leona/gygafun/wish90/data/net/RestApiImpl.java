/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package leona.gygafun.wish90.data.net;

import android.content.Context;

import leona.gygafun.wish90.data.entity.UserEntity;
import leona.gygafun.wish90.data.entity.UserMomentEntity;
import leona.gygafun.wish90.data.entity.mapper.UserEntityJsonMapper;
import leona.gygafun.wish90.data.exception.NetworkConnectionException;

import org.json.JSONException;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import leona.gygafun.wish90.data.entity.mapper.UserEntityJsonMapper;
import rx.Observable;
import rx.Subscriber;

/**
 * {@link RestApi} implementation for retrieving data from the network.
 */
public class RestApiImpl implements RestApi {

  private final Context context;
  private final UserEntityJsonMapper userEntityJsonMapper;

  /**
   * Constructor of the class
   *
   * @param context {@link android.content.Context}.
   * @param userEntityJsonMapper {@link UserEntityJsonMapper}.
   */
  public RestApiImpl(Context context, UserEntityJsonMapper userEntityJsonMapper) {
    if (context == null || userEntityJsonMapper == null) {
      throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
    }
    this.context = context.getApplicationContext();
    this.userEntityJsonMapper = userEntityJsonMapper;
  }

  @Override
  public Observable<List<UserMomentEntity>> userMomentEntityList() {
    return Observable.create(new Observable.OnSubscribe<List<UserMomentEntity>>() {
      @Override
      public void call(Subscriber<? super List<UserMomentEntity>> subscriber) {

        try {
          String responseUserEntities = getUserEntitiesFromApi();
          if (responseUserEntities != null) {
            subscriber.onNext(userEntityJsonMapper.transformUserMomentEntityCollection(
                    responseUserEntities));
            subscriber.onCompleted();
          } else {
            subscriber.onError(new NetworkConnectionException());
          }
        } catch (Exception e) {
            subscriber.onError(new NetworkConnectionException(e.getCause()));
          }

      }
    });
  }

  @Override
  public Observable<UserMomentEntity> userEntityById(final int userId) {
    return Observable.create(new Observable.OnSubscribe<UserMomentEntity>() {
      @Override
      public void call(Subscriber<? super UserMomentEntity> subscriber) {

          try {
            String responseUserDetails = getUserDetailsFromApi(userId);
            if (responseUserDetails != null) {
              subscriber.onNext(userEntityJsonMapper.transformUserMomentEntity(responseUserDetails));
              subscriber.onCompleted();
            } else {
              subscriber.onError(new NetworkConnectionException());
            }
          } catch (Exception e) {
            subscriber.onError(new NetworkConnectionException(e.getCause()));
          }

      }
    });
  }

  private String getUserEntitiesFromApi() throws MalformedURLException, JSONException,ParseException {
    return new ApiConnection(context).requestSyncCall();
  }

  private String getUserDetailsFromApi(int userId) throws MalformedURLException, JSONException,ParseException {
    String apiUrl = RestApi.API_URL_GET_USER_DETAILS + userId + ".json";
    return new ApiConnection(context).requestSyncCall();
  }

  /**
   * Checks if the device has any active internet connection.
   *
   * @return true device with internet connection, otherwise false.
   */

}
