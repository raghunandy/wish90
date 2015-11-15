
package leona.gygafun.wish90.data.entity;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * Created by rkrasniqi on 10/6/15.
 */


public class UserEntity {

    private int userID = 0;
    private String username = null;
    private String password = null;
    private String userEmailAddress = null;
    private String oAuthToken = null;
    private Date currentSignInDate;
    private Date lastSignInDate;
    private int userAccessCount = 0;

    public UserEntity(int userID, String username) {
        this.userID=userID;
        this.username=username;
    }

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



}