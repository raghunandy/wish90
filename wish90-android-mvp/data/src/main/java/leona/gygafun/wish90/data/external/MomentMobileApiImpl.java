/**
 Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
 */
package leona.gygafun.wish90.data.external;

import android.content.Context;

import leona.gygafun.wish90.data.MomentApi;
import leona.gygafun.wish90.data.entity.UserMomentEntity;
import leona.gygafun.wish90.data.entity.mapper.UserEntityJsonMapper;
import leona.gygafun.wish90.data.exception.NetworkConnectionException;

import org.json.JSONException;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

public class MomentMobileApiImpl implements MomentApi {

  private final Context context;
  private final UserEntityJsonMapper userEntityJsonMapper;


  public MomentMobileApiImpl(Context context, UserEntityJsonMapper userEntityJsonMapper) {
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
            subscriber.onError(new Exception());
          }
        } catch (Exception e) {
            subscriber.onError(new Exception(e.getCause()));
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
              subscriber.onError(new Exception());
            }
          } catch (Exception e) {
            subscriber.onError(new Exception(e.getCause()));
          }

      }
    });
  }

  private String getUserEntitiesFromApi() throws MalformedURLException, JSONException,ParseException {
    return new MobileApiConnection(context).requestSyncCall();
  }

  private String getUserDetailsFromApi(int userId) throws MalformedURLException, JSONException,ParseException {
    return new MobileApiConnection(context).requestSyncCall();
  }


}
