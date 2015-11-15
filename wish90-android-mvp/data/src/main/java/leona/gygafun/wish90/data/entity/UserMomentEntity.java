package leona.gygafun.wish90.data.entity;

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
    public ContactEntity getRefContact() {
        return refContact;
    }
    public void setRefContact(ContactEntity refContact) {
        this.refContact = refContact;
    }
    private Date momentDateTime;
    private boolean customized;
    private String configurations ;
    private ContactEntity refContact ;

    public UserMomentEntity(Date momentDateTime, ContactEntity refContact) {
        this.momentDateTime = momentDateTime;
        this.refContact = refContact;
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
