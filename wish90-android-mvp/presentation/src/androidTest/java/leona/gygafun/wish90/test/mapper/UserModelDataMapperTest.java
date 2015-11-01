/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.test.mapper;

import leona.gygafun.wish90.domain.User;
import leona.gygafun.wish90.presentation.mapper.UserModelDataMapper;
import leona.gygafun.wish90.presentation.model.UserModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import junit.framework.TestCase;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

public class UserModelDataMapperTest extends TestCase {

  private static final int FAKE_USER_ID = 123;
  private static final String FAKE_FULLNAME = "Tony Stark";

  private UserModelDataMapper userModelDataMapper;

  @Override protected void setUp() throws Exception {
    super.setUp();
    userModelDataMapper = new UserModelDataMapper();
  }

  public void testTransformUser() {
    User user = createFakeUser();
    UserModel userModel = userModelDataMapper.transform(user);

    assertThat(userModel, is(instanceOf(UserModel.class)));
    assertThat(userModel.getUserID(), is(FAKE_USER_ID));
    assertThat(userModel.getUsername(), is(FAKE_FULLNAME));
  }

  public void testTransformUserCollection() {
    User mockUserOne = mock(User.class);
    User mockUserTwo = mock(User.class);

    List<User> userList = new ArrayList<User>(5);
    userList.add(mockUserOne);
    userList.add(mockUserTwo);

    Collection<UserModel> userModelList = userModelDataMapper.transform(userList);

    assertThat(userModelList.toArray()[0], is(instanceOf(UserModel.class)));
    assertThat(userModelList.toArray()[1], is(instanceOf(UserModel.class)));
    assertThat(userModelList.size(), is(2));
  }

  private User createFakeUser() {
    User user = new User(FAKE_USER_ID);
    user.setUsername(FAKE_FULLNAME);

    return user;
  }
}
