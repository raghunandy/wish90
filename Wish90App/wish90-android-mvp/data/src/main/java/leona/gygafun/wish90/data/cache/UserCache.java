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
package leona.gygafun.wish90.data.cache;

import leona.gygafun.wish90.data.entity.UserEntity;
import leona.gygafun.wish90.data.entity.UserMomentEntity;

import rx.Observable;

/**
 * An interface representing a user Cache.
 */
public interface UserCache {
    /**
     * Gets an {@link rx.Observable} which will emit a {@link UserEntity}.
     *
     * @param userId The user id to retrieve data.
     */
     Observable<UserEntity> get(final int userId);

    /**
     * Puts and element into the cache.
     *
     * @param userEntity Element to insert in the cache.
     */
    void put(UserEntity userEntity);

    /**
     * Checks if an element (User) exists in the cache.
     *
     * @param userId The id used to look for inside the cache.
     * @return true if the element is cached, otherwise false.
     */
    boolean isCached(final int userId);



    /**
     * Gets an {@link rx.Observable} which will emit a {@link UserEntity}.
     *
     * @param userId The user id to retrieve data.
     */
   // Observable<UserMomentEntity> getMoment(final int userId);

    /**
     * Puts and element into the cache.
     *
     * @param userEntity Element to insert in the cache.
     */
  //  void put(UserMomentEntity userEntity);


    /**
     * Checks if the cache is expired.
     *
     * @return true, the cache is expired, otherwise false.
     */
    boolean isExpired();

    /**
     * Evict all elements of the cache.
     */
    void evictAll();
}