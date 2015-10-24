/* Wish90 */
package leona.gygafun.wish90.domain;

import java.util.Date;
import java.util.List;

/**
 * Class that represents a User in the domain layer.
 */
public class UserMoment{

    private int momentID = 0;
    private int userID = 0;
    private List<String> mommentType = null;
    private Date momentDateTime;
    private Boolean isCustomizable = true;
    private String configurations = null;
    private String refContacts = null;

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

    public Boolean getIsCustomizable() {
      return isCustomizable;
    }

    public void setIsCustomizable(Boolean isCustomizable) {
      this.isCustomizable = isCustomizable;
    }

    public String getConfigurations() {
      return configurations;
    }

    public void setConfigurations(String configurations) {
      this.configurations = configurations;
    }

    public String getRefContacts() {
      return refContacts;
    }

    public void setRefContacts(String refContacts) {
      this.refContacts = refContacts;
    }

    @Override
    public String toString() {
      return "UserMomentEntity{" +
              "momentID=" + momentID +
              ", userID=" + userID +
              ", mommentType=" + mommentType +
              ", momentDateTime=" + momentDateTime +
              ", isCustomizable=" + isCustomizable +
              ", configurations='" + configurations + '\'' +
              ", refContacts='" + refContacts + '\'' +
              '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      UserMoment that = (UserMoment) o;

      if (momentID != that.momentID) return false;
      if (userID != that.userID) return false;
      if (mommentType != null ? !mommentType.equals(that.mommentType) : that.mommentType != null)
        return false;
      if (momentDateTime != null ? !momentDateTime.equals(that.momentDateTime) : that.momentDateTime != null)
        return false;
      if (isCustomizable != null ? !isCustomizable.equals(that.isCustomizable) : that.isCustomizable != null)
        return false;
      if (configurations != null ? !configurations.equals(that.configurations) : that.configurations != null)
        return false;
      return !(refContacts != null ? !refContacts.equals(that.refContacts) : that.refContacts != null);

    }

    @Override
    public int hashCode() {
      int result = momentID;
      result = 31 * result + userID;
      result = 31 * result + (mommentType != null ? mommentType.hashCode() : 0);
      result = 31 * result + (momentDateTime != null ? momentDateTime.hashCode() : 0);
      result = 31 * result + (isCustomizable != null ? isCustomizable.hashCode() : 0);
      result = 31 * result + (configurations != null ? configurations.hashCode() : 0);
      result = 31 * result + (refContacts != null ? refContacts.hashCode() : 0);
      return result;
    }
  }