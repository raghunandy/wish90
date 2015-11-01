/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.data.repository.datasource;

import com.fernandocejas.android10.sample.data.ApplicationTestCase;
import leona.gygafun.wish90.data.cache.UserCache;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class DiskUserDataStoreTest extends ApplicationTestCase {

  private static final int FAKE_USER_ID = 11;

  private DiskUserDataStore diskUserDataStore;

  @Mock private UserCache mockUserCache;

  @Rule public ExpectedException expectedException = ExpectedException.none();

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    diskUserDataStore = new DiskUserDataStore(mockUserCache);
  }

  @Test
  public void testGetUserEntityListUnsupported() {
    expectedException.expect(UnsupportedOperationException.class);
    diskUserDataStore.userEntityList();
  }

  @Test
  public void testGetUserEntityDetailesFromCache() {
    diskUserDataStore.userEntityDetails(FAKE_USER_ID);
    verify(mockUserCache).get(FAKE_USER_ID);
  }
}
