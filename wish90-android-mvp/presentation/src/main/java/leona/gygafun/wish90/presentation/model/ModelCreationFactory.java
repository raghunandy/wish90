package leona.gygafun.wish90.presentation.model;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Raghu on 11/22/2015.
 */
public class ModelCreationFactory {
    public static UserMomentModel createUserMomentModel(ContactModel contactModel,Date dateTime,String ... momentTypes){
        UserMomentModel umm=new UserMomentModel();
        umm.setCustomized(true);
        umm.setMomentDateTime(dateTime);
        umm.setMommentType(Arrays.asList(momentTypes));
        umm.setRefContact(contactModel);
        return umm;
    }

}
