/* Wish90 */
package leona.gygafun.wish90.data.repository.datasource;

import com.fernandocejas.android10.sample.data.ApplicationTestCase;
import leona.gygafun.wish90.data.cache.UserCache;
import leona.gygafun.wish90.data.entity.UserEntity;
import leona.gygafun.wish90.data.net.RestApi;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rx.Observable;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class CloudUserDataStoreTest extends ApplicationTestCase {

  private static final int FAKE_USER_ID = 765;

  private CloudUserDataStore cloudUserDataStore;

  @Mock private RestApi mockRestApi;
  @Mock private UserCache mockUserCache;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    cloudUserDataStore = new CloudUserDataStore(mockRestApi, mockUserCache);
  }

  @Test
  public void testGetUserEntityListFromApi() {
    cloudUserDataStore.userEntityList();
    verify(mockRestApi).userEntityList();
  }

  @Test
  public void testGetUserEntityDetailsFromApi() {
    UserEntity fakeUserEntity = new UserEntity();
    Observable<UserEntity> fakeObservable = Observable.just(fakeUserEntity);
    given(mockRestApi.userEntityById(FAKE_USER_ID)).willReturn(fakeObservable);

    cloudUserDataStore.userEntityDetails(FAKE_USER_ID);

    verify(mockRestApi).userEntityById(FAKE_USER_ID);
  }
}
