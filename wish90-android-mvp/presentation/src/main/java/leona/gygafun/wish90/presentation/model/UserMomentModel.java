package leona.gygafun.wish90.presentation.model;
/* Wish90 */
/**
 * Created by rkrasniqi on 10/23/15.
 */


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Class that represents a User in the domain layer.
 */
public class UserMomentModel{

    private int momentID ;
    private int userID ;
    private List<String> mommentType = new ArrayList<>();
    private Date momentDateTime;
    private boolean customized;
    private String configurations ;
    private String refContacts ;

    public UserMomentModel(int userMoment) {
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

    public String getRefContacts() {
        return refContacts;
    }

    public void setRefContacts(String refContacts) {
        this.refContacts = refContacts;
    }


}