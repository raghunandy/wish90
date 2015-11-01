/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.domain;

import java.util.Date;


/**
 * Class that represents a User in the domain layer.
 */
public class User {


  private int userID = 0;
  private String username = null;
  private String password = null;
  private String userEmailAddress = null;
  private String oAuthToken = null;
  private Date currentSignInDate;
  private Date lastSignInDate;
  private int userAccessCount = 0;

  public User(int userId) {}

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
    return "User{" +
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

    User that = (User) o;

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
