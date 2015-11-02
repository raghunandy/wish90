package leona.gygafun.wish90.presentation.model;
/* Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/ */
/**
 * Created by rkrasniqi on 10/23/15.
 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Class that represents a User in the domain layer.
 */
public class UserMomentModel implements Serializable{

    private int momentID ;
    private int userID ;
    private List<String> mommentType = new ArrayList<>();
    private Date momentDateTime;
    private boolean customized;
    private String configurations ;
    public ContactModel getRefContact() {
        return refContact;
    }

    public void setRefContact(ContactModel refContact) {
        this.refContact = refContact;
    }

    private ContactModel refContact ;

    public UserMomentModel() {
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