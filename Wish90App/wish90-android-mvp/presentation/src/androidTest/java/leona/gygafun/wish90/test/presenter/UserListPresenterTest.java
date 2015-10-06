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
package leona.gygafun.wish90.test.presenter;

import android.content.Context;
import android.test.AndroidTestCase;
import leona.gygafun.wish90.domain.interactor.GetUserList;
import leona.gygafun.wish90.presentation.mapper.UserModelDataMapper;
import leona.gygafun.wish90.presentation.presenter.UserListPresenter;
import leona.gygafun.wish90.presentation.view.UserListView;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rx.Subscriber;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class UserListPresenterTest extends AndroidTestCase {

  private UserListPresenter userListPresenter;

  @Mock
  private Context mockContext;
  @Mock
  private UserListView mockUserListView;
  @Mock
  private GetUserList mockGetUserList;
  @Mock
  private UserModelDataMapper mockUserModelDataMapper;

  @Override protected void setUp() throws Exception {
    super.setUp();
    MockitoAnnotations.initMocks(this);
    userListPresenter = new UserListPresenter(mockGetUserList, mockUserModelDataMapper);
    userListPresenter.setView(mockUserListView);
  }

  public void testUserListPresenterInitialize() {
    given(mockUserListView.getContext()).willReturn(mockContext);

    userListPresenter.initialize();

    verify(mockUserListView).hideRetry();
    verify(mockUserListView).showLoading();
    verify(mockGetUserList).execute(any(Subscriber.class));
  }
}
