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
package leona.gygafun.wish90.data.entity;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * Created by rkrasniqi on 10/6/15.
 */


public class UserEntity {

    @SerializedName("user_id")
    private int userID = 0;

    @SerializedName("username")
    private String username = null;

    @SerializedName("paswword")
    private String password = null;

    @SerializedName("user_email_address")
    private String userEmailAddress = null;

    @SerializedName("o_auth_token")
    private String oAuthToken = null;

    @SerializedName("current_sign_in_date")
    private Date currentSignInDate;

    @SerializedName("last_sign_in_date")
    private Date lastSignInDate;

    @SerializedName("user_access_count")
    private int userAccessCount = 0;


    public UserEntity() {}

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    public String getoAuthToken() {
        return oAuthToken;
    }

    public void setoAuthToken(String oAuthToken) {
        this.oAuthToken = oAuthToken;
    }

    public Date getCurrentSignInDate() {
        return currentSignInDate;
    }

    public void setCurrentSignInDate(Date currentSignInDate) {
        this.currentSignInDate = currentSignInDate;
    }

    public Date getLastSignInDate() {
        return lastSignInDate;
    }

    public void setLastSignInDate(Date lastSignInDate) {
        this.lastSignInDate = lastSignInDate;
    }

    public int getUserAccessCount() {
        return userAccessCount;
    }

    public void setUserAccessCount(int userAccessCount) {
        this.userAccessCount = userAccessCount;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userEmailAddress='" + userEmailAddress + '\'' +
                ", oAuthToken='" + oAuthToken + '\'' +
                ", currentSignInDate=" + currentSignInDate +
                ", lastSignInDate=" + lastSignInDate +
                ", userAccessCount=" + userAccessCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userID != that.userID) return false;
        if (userAccessCount != that.userAccessCount) return false;
        if (username != null ? !username.equals(that.username) : that.username != null)
            return false;
        if (password != null ? !password.equals(that.password) : that.password != null)
            return false;
        if (userEmailAddress != null ? !userEmailAddress.equals(that.userEmailAddress) : that.userEmailAddress != null)
            return false;
        if (oAuthToken != null ? !oAuthToken.equals(that.oAuthToken) : that.oAuthToken != null)
            return false;
        if (currentSignInDate != null ? !currentSignInDate.equals(that.currentSignInDate) : that.currentSignInDate != null)
            return false;
        return !(lastSignInDate != null ? !lastSignInDate.equals(that.lastSignInDate) : that.lastSignInDate != null);

    }

    @Override
    public int hashCode() {
        int result = userID;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userEmailAddress != null ? userEmailAddress.hashCode() : 0);
        result = 31 * result + (oAuthToken != null ? oAuthToken.hashCode() : 0);
        result = 31 * result + (currentSignInDate != null ? currentSignInDate.hashCode() : 0);
        result = 31 * result + (lastSignInDate != null ? lastSignInDate.hashCode() : 0);
        result = 31 * result + userAccessCount;
        return result;
    }


}