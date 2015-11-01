/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
package leona.gygafun.wish90.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class that represents a User in the domain layer.
 */
public class UserMoment{

    private int momentID ;
    private int userID ;
    private List<String> mommentType =new ArrayList<>();
    private Date momentDateTime;
    private String configurations ;
    private Contact refContact ;

    public Contact getRefContact() {
        return refContact;
    }

    public void setRefContact(Contact refContact) {
        this.refContact = refContact;
    }

    private boolean customized;

    public UserMoment(int userMoment) {
    }

    public int getMomentID() {
      return momentID;
    }

    public void setMomentID(int momentID) {
      this.momentID = momentID;
    }

    public int getUserID() {
      return userID;
    }

    public void setUserID(int userID) {
      this.userID = userID;
    }

    public List<String> getMommentType() {
      return mommentType;
    }

    public void setMommentType(List<String> mommentType) {
      this.mommentType = mommentType;
    }

    public Date getMomentDateTime() {
      return momentDateTime;
    }

    public void setMomentDateTime(Date momentDateTime) {
      this.momentDateTime = momentDateTime;
    }

    public boolean isCustomized() {
        return customized;
    }

    public void setCustomized(boolean customized) {
        this.customized = customized;
    }

    public String getConfigurations() {
      return configurations;
    }

    public void setConfigurations(String configurations) {
      this.configurations = configurations;
    }


  }