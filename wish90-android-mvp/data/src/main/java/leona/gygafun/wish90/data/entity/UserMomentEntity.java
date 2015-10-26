package leona.gygafun.wish90.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rkrasniqi on 10/6/15.
 */


public class UserMomentEntity {

    private int momentID;

    private int userID;

    private List<String> mommentType = new ArrayList<>();

    private Date momentDateTime;

    private boolean customized;

    private String configurations ;

    private String refContacts ;

    public UserMomentEntity(Date momentDateTime, String refContacts) {
        this.momentDateTime = momentDateTime;
        this.refContacts = refContacts;
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
