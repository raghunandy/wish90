/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package leona.gygafun.wish90.data.entity.mapper;

import leona.gygafun.wish90.data.entity.UserMomentEntity;
import leona.gygafun.wish90.data.entity.UserEntity;
import leona.gygafun.wish90.domain.User;
import leona.gygafun.wish90.domain.UserMoment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link UserEntity} (in the data layer) to {@link User} in the
 * domain layer.
 */
@Singleton
public class UserEntityDataMapper {

    @Inject
    public UserEntityDataMapper() {
    }

    /**
     * Transform a {@link UserEntity} into an {@link User}.
     *
     * @param userEntity Object to be transformed.
     * @return {@link User} if valid {@link UserEntity} otherwise null.
     */
    public User transform(UserEntity userEntity) {
        User user = null;
        if (userEntity != null) {
            user = new User(userEntity.getUserId());
            user.setCoverUrl(userEntity.getCoverUrl());
            user.setFullName(userEntity.getFullname());
            user.setDescription(userEntity.getDescription());
            user.setFollowers(userEntity.getFollowers());
            user.setEmail(userEntity.getEmail());
        }

        return user;
    }

    /**
     * Transform a List of {@link UserEntity} into a Collection of {@link User}.
     *
     * @param userEntityCollection Object Collection to be transformed.
     * @return {@link User} if valid {@link UserEntity} otherwise null.
     */
    public List<User> transform(Collection<UserEntity> userEntityCollection) {
        List<User> userList = new ArrayList<>(20);
        User user;
        for (UserEntity userEntity : userEntityCollection) {
            user = transform(userEntity);
            if (user != null) {
                userList.add(user);
            }
        }

        return userList;
    }


    public UserMoment transform(UserMomentEntity dateTimeEntity) {
        UserMoment userMoment = null;
        if (dateTimeEntity != null) {
            userMoment=dateTimeEntity;
//            userMoment = new UserMoment(dateTimeEntity.getMomentId());
//            user.setCoverUrl(userEntity.getCoverUrl());
//            user.setFullName(userEntity.getFullname());
//            user.setDescription(userEntity.getDescription());
//            user.setFollowers(userEntity.getFollowers());
//            user.setEmail(userEntity.getEmail());
        }

        return userMoment;
    }

    /**
     * Transform a List of {@link UserEntity} into a Collection of {@link User}.
     *
     * @param userEntityCollection Object Collection to be transformed.
     * @return {@link User} if valid {@link UserEntity} otherwise null.
     */
    public List<UserMoment> transformMoments(Collection<UserMomentEntity> userEntityCollection) {
        List<UserMoment> userList = new ArrayList<>(20);
        UserMoment userMoment;
        for (UserMomentEntity userMomentEntity : userEntityCollection) {
            userMoment = transform(userMomentEntity);
            if (userMoment != null) {
                userList.add(userMoment);
            }
        }

        return userList;
    }
}
