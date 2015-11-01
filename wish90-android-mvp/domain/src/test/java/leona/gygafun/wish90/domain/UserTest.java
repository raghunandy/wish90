/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {

  private static final int FAKE_USER_ID = 8;

  private leona.gygafun.wish90.domain.User user;

  @Before
  public void setUp() {
    user = new leona.gygafun.wish90.domain.User(FAKE_USER_ID);
  }

  @Test
  public void testUserConstructorHappyCase() {
    int userId = user.getUserId();

    assertThat(userId, is(FAKE_USER_ID));
  }
}
