package leona.gygafun.wish90.data.entity;

/**
 * Created by Deepti on 10/30/2015.
 */
public class ContactEntity {
    private long contactNumber;
    private String contactName;
    private String contactImage;
    private String contactEmail;

    public ContactEntity(String contactName, String contactImage) {
        this.contactName = contactName;
        this.contactImage = contactImage;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactImage() {
        return contactImage;
    }

    public void setContactImage(String contactImage) {
        this.contactImage = contactImage;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
